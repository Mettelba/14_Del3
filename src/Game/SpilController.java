package Game;
import Felter.*;
import gui_main.*;
import gui_fields.*;



public class SpilController {
	private int aktivspiller = 1;//Vi starter med spiller 1

	private Spiller[] spiller;
	private Raflebæger raflebæger = new Raflebæger(6);
	private Spilbræt spillebræt;
	private GUI spilgui;
	private GUI_Player[] guispiller;
	private GUI_Field[] guifelter;
	private Felt[] felter; 
	private RegelController regler; 


	public SpilController(Spiller[] spiller) {

		spillebræt = new Spilbræt(spiller);
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		guifelter = spillebræt.hentGUIfelter();
		regler = new RegelController(spiller, felter, guispiller, spilgui, guifelter);
		this.spiller = spiller;
	}

	public void skiftSpiller(int antalspillere) {
		// Kør spilsekvens hvis aktivspiller ikke er bankerot.
		while(true) {
			spilSekvens(spiller, aktivspiller); //send spiller ind i spilsekvens
			if (spiller[aktivspiller].erDuBankerot()==true) { //Hvis spilleren er bankerot
				endGame(antalspillere);
				break;//Håndter slutspil optælling af penge for de andre spillere etc.
			}
			aktivspiller++;

			//Hvis vi er nået til sidste spiller
			if (aktivspiller==antalspillere+1) {
				aktivspiller=1; //Sæt den aktive spiller til spiller1

			}
		}
	}

	public void spilSekvens(Spiller[] spiller, int aktivspiller) {
		this.aktivspiller = aktivspiller;
		this.spiller = spiller;	
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
			if (spiller[aktivspiller].hentPosition()+raflebæger.hentTerning1værdi()>23) {
				feltrykkettil = spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi() - 24;
				spiller[aktivspiller].modtagGevinst(((StartFelt)felter[Konstanter.STARTFELT]).hentPasserStart()); //Modtag det som der står i passer start feltet.
			} else {
				feltrykkettil = spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
			}

			//sæt position for den aktive spiller i spiller array og i GUI
			this.spiller[this.aktivspiller].sætPosition(feltrykkettil);
			guispiller[aktivspiller].setBalance(spiller[aktivspiller].indeståendeSpillerKonto());

			//Udfør regel på spiller.
			kaldRegel(spiller, felter, aktivspiller);

		}while (spiller[aktivspiller].hentEkstraTur() == true);
	}

	private void kaldRegel(Spiller[] spiller, Felt[] felter, int aktivspiller) {
		int position = spiller[aktivspiller].hentPosition();
		int felttype = felter[position].hentFeltType();
		int feltejer = felter[position].hentEjer();
		int betalt;
		boolean valg;
		String beskedstreng;

		//Opdater GUI for position
		spilgui.getFields()[position].setCar(guispiller[aktivspiller], true);


		//Særregler for felter
		switch (felttype) {

		case 1://Normal felt
			//Her kan du så få lov at købe grunden hvis du vil.
			//GUI besked vil du købe grunden ja/nej.
			if (feltejer == 0 && spiller[aktivspiller].indeståendeSpillerKonto() > felter[position].hentPris()) {//har aktivspiller råd til at købe det.

				valg = spilgui.getUserLeftButtonPressed(felter[position].hentBeskedTekst() + " og den er til salg. vil du købe grunden ?", "Ja", "Nej");
				if (valg == true) {
					regler.normalFeltKøbGrund(aktivspiller, position);
				}
			}

			//Felt er ejet af en anden spiller og det ikke er spiller 0
			if (feltejer != aktivspiller && feltejer != 0) {
				betalt = regler.normalFeltEjetAfAnden(aktivspiller, position);

				beskedstreng = felter[position].hentBeskedTekst() + ", og du skal betale " + spiller[felter[position].hentEjer()].hentNavn() + " "+ betalt +"kr i afgift.";

				if (spiller[aktivspiller].erDuBankerot() == true) {
					beskedstreng = beskedstreng + ", og du gik desværre også bankerot. Spillet er færdigt";
				}
				spilgui.showMessage(beskedstreng);
			}
			break;

		case 2://Et tog
			regler.togFelt(aktivspiller, position);
			break;

		case 3://Fyrværkeri eller delfiner eller Café
			betalt = regler.entreFelt(aktivspiller, position);	
			break;


		case 4://Onkel Mangepenges byttepenge
			regler.onkelMangePengeFelt(aktivspiller);
			break;

		case 5://Gå på Cafe felt
			regler.gåTilCafeFelt(aktivspiller);	
			kaldRegel(spiller, felter, aktivspiller);

			break;

		case 6://START
			regler.startFelt(aktivspiller);
			break;
		}
	}

	public void endGame(int antalspillere) {
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
			vinderpodie[tæller][0]=tæller;
			vinderpodie[tæller][1]=fastejendom + spiller[tæller].indeståendeSpillerKonto();
		}
		spiller[0].sætKontoVærdi(0);
		//Sortering af vinder podie.

		while (sorteret != false) {
			sorteret = false;

			for (int tæller = 0;tæller <= antalspillere-1;tæller++) {

				if (vinderpodie[tæller][1]< vinderpodie[tæller+1][1]) {
					vinderpodie[0][0] = vinderpodie[tæller][0];
					vinderpodie[0][1] = vinderpodie[tæller][1];

					vinderpodie[tæller][0] = vinderpodie[tæller+1][0];
					vinderpodie[tæller][1] = vinderpodie[tæller+1][1];

					vinderpodie[tæller+1][0] = vinderpodie[0][0];
					vinderpodie[tæller+1][1] = vinderpodie[0][1];

					vinderpodie[0][0]= 0;
					vinderpodie[0][1]= 1;

					sorteret = true;
				}			
			}

			for (int tæller = 1; tæller <= antalspillere; tæller++) {
				beskedtekst = tæller + ".plads: " + spiller[vinderpodie[tæller][0]].hentNavn() + " med en samlet formue på" + vinderpodie[tæller][1] + "\n";
				
			}
			spilgui.showMessage(beskedtekst);
		}
	}
}


