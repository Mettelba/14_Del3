package Game;
import Felter.*;
import gui_main.*;
import gui_fields.*;



public class SpilController {

	private Raflebæger raflebæger = new Raflebæger(6);
	private Spilbræt spillebræt;
	private GUI spilgui;
	private GUI_Player[] guispiller;
	private GUI_Field[] guifelter;
	private Felt[] felter; 
	private RegelController regler; 
	private HentSpillere lavspillere = new HentSpillere();
	private Spiller[] spiller = lavspillere.hentSpillere();

	public SpilController() {

		spillebræt = new Spilbræt(spiller);
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
	}

	public void skiftSpiller() {
		int aktivspiller = 1;//Vi starter med spiller 1
		int antalspillere = lavspillere.hentAntalSpillere();
		
		
		// Kør spilsekvens
		while(true) {
			spilSekvens(spiller, aktivspiller); //send spiller ind i spilsekvens
			if (spiller[aktivspiller].erDuBankerot()==true) { //Hvis spilleren er bankerot pga. spilsekvensen
				endGame(spiller, antalspillere);//Håndter slutspil optælling af penge for spillere etc.
				break;
			}
			aktivspiller++;

			//Hvis vi er nået til sidste spiller
			if (aktivspiller==antalspillere+1) {
				aktivspiller=1; //Sæt den aktive spiller til spiller1
			}
		}
	}	

	public void spilSekvens(Spiller[] spiller, int aktivspiller) {
		int feltrykkettil;

		do {
			//Hvis spiller er på sin ekstratur, så skal ekstratur for spilleren sættes til false
			if (spiller[aktivspiller].hentEkstraTur()==true){
				spiller[aktivspiller].sætEkstraTur(false);
			}

			//slå med terningerne.
			spilgui.showMessage(spiller[aktivspiller].hentNavn() + ". Tryk på OK for at slå med terningerner");
			raflebæger.ryst();

			//OPDATER GUI. Sæt terninger og fjern bilen.
			spilgui.getFields()[spiller[aktivspiller].hentPosition()].setCar(guispiller[aktivspiller], false);
			spilgui.setDie(raflebæger.hentTerning1værdi());//Opdater GUI for terninger

			//Check for om man kommer over start
			if (spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi()>23) {
				feltrykkettil = spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi() - 24;
				spiller[aktivspiller].indsætPåKonto(((StartFelt)felter[Konstanter.STARTFELT]).hentPasserStart()); //Modtag det som der står i passer start feltet.
			} else {
				feltrykkettil = spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
			}

			//sæt ny position for den aktive spiller i spiller array,
			spiller[aktivspiller].sætPosition(feltrykkettil);


			//Udfør regel på spiller.
			kaldRegel(spiller, felter, aktivspiller);

		}while (spiller[aktivspiller].hentEkstraTur() == true);
	}

	private void kaldRegel(Spiller[] spiller, Felt[] felter, int aktivspiller) {
		int position = spiller[aktivspiller].hentPosition();
		int felttype = felter[position].hentFeltType();
		int feltejer = felter[position].hentEjer();

		//REGLER!
		switch (felttype) {

		case 1://Normal felt
			//Her kan du så få lov at købe grunden hvis du vil, og den ikke er ejet af en anden spiller.
			//Hvis den er det skal der betales penge til ejeren.
			regler.flytSpiller(aktivspiller, position);

			if (feltejer != aktivspiller && feltejer != 0) {
				regler.normalFeltEjetAfAnden(aktivspiller, position);
			}else 
			{
				regler.normalFeltKøbGrund(aktivspiller, position);
			}
			break;

		case 2://Et tog
			regler.flytSpiller(aktivspiller, position);
			regler.togFelt(aktivspiller, position);
			break;

		case 3://Fyrværkeri eller delfiner eller Café
			regler.flytSpiller(aktivspiller, position);
			regler.entreFelt(aktivspiller, position);	
			break;


		case 4://Onkel Mangepenges byttepenge
			regler.flytSpiller(aktivspiller, position);
			regler.onkelMangePengeFelt(aktivspiller);
			break;

		case 5://Gå på Cafe felt
			regler.flytSpiller(aktivspiller, position);
			regler.gåTilCafeFelt(aktivspiller);	
			kaldRegel(spiller, felter, aktivspiller);

			break;

		case 6://START
			regler.flytSpiller(aktivspiller, position);
			regler.startFelt(aktivspiller);
			break;
		}
	}

	public void endGame(Spiller[] spiller, int antalspillere) {
		int fastejendom = 0;
		String beskedtekst = "";
		int[][] vinderpodie = new int[2][antalspillere+1];
		boolean sorteret = true;

		//Optælling af samlet formue for hver spiller.
		for (int tæller = 1;tæller <= antalspillere;tæller++) {
			//sammentæl værdi af ejet fast ejendom.
			for (int tæller2 = 0;tæller2 <=23;tæller2++) {
				if (felter[tæller2].hentEjer() == tæller) {
					fastejendom = fastejendom + felter[tæller2].hentPris();
				}
			}
			vinderpodie[0][tæller]=tæller;
			vinderpodie[1][tæller]=fastejendom + spiller[tæller].indeståendeSpillerKonto();
		}
		spiller[0].indsætPåKonto(0);
		//Sortering af vinder podie.

		while (sorteret != false) {
			sorteret = false;

			for (int tæller = 1;tæller <= antalspillere-1;tæller++) {
				if (vinderpodie[1][tæller]< vinderpodie[1][tæller+1]) {
					vinderpodie[0][0] = vinderpodie[0][tæller];
					vinderpodie[1][0] = vinderpodie[1][tæller];

					vinderpodie[0][tæller] = vinderpodie[0][tæller+1];
					vinderpodie[1][tæller] = vinderpodie[1][tæller+1];

					vinderpodie[0][tæller+1] = vinderpodie[0][0];
					vinderpodie[1][tæller+1] = vinderpodie[1][0];

					vinderpodie[0][0]= 0;
					vinderpodie[1][0]= 0;

					sorteret = true;
				}			
			}
		}
		for (int tæller = 1; tæller <= antalspillere; tæller++) {
			beskedtekst =  beskedtekst + tæller + ".plads- " + spiller[vinderpodie[0][tæller]].hentNavn() + " med en samlet formue på " + vinderpodie[1][tæller] + " kr. \n";
		}
		System.out.println(beskedtekst);
	}
}

