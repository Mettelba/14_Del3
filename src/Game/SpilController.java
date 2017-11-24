package Game;
import Felter.*;
import gui_main.*;
import gui_fields.*;



public class SpilController {

	private int feltnr;
	private int antalspillere;
	private int aktivspiller;

	private Spiller[] spiller;
	private Raflebæger raflebæger = new Raflebæger(3);
	private Spilbræt spillebræt;
	private GUI spilgui;
	private GUI_Player[] guispiller;

	private Felt[] felter; 

	private RegelController regler; 


	public SpilController(Spiller[] spiller) {

		spillebræt = new Spilbræt(spiller);
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		guispiller = spillebræt.hentGUISpiller();
		regler = new RegelController(spiller, felter);
	}

	public Spiller[] spilsekvens(Spiller[] spiller, int aktivspiller) {
		this.aktivspiller = aktivspiller;
		this.spiller = spiller;	
		int position;
		int felttype;
		int feltrykkettil;

		do {
			//Hvis spiller er på sin ekstratur, så skal ekstratur for spilleren sættes til false
			if (spiller[aktivspiller].hentEkstraTur()==true){
				spiller[aktivspiller].sætEkstraTur(false);
			}
			

			spilgui.showMessage(spiller[aktivspiller].hentNavn() + ". Tryk på OK for at rulle terningerner");
			raflebæger.ryst();

			//OPDATER GUI. Sæt terninger og fjern bilen.
			spilgui.getFields()[spiller[aktivspiller].hentPosition()].removeAllCars();
			spilgui.setDie(raflebæger.hentTerning1værdi());//Opdater GUI for terninger

			//Check for om man kommer over start
			if (spiller[aktivspiller].hentPosition()+raflebæger.hentTerning1værdi()>23) {
				feltrykkettil = spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi() - 24;
				spiller[aktivspiller].modtagGevinst(2); //Modtag 2 kr.
			} else {
				feltrykkettil = spiller[aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
			}
			
			//sæt position for den aktive spiller i spiller array
			this.spiller[this.aktivspiller].sætPosition(feltrykkettil);
			position = this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
		
			//Udfør regel på spiller.
			kaldRegel(spiller, felter, aktivspiller, guispiller);

			
		}while (spiller[aktivspiller].hentEkstraTur() == true);
		return this.spiller;
		
		
	}



	private void kaldRegel(Spiller[] spiller, Felt[] felter, int aktivspiller, GUI_Player[] guispiller) {
		int position = spiller[aktivspiller].hentPosition();
		int felttype = felter[position].hentFeltType();
		int feltejer = felter[position].hentEjer();
		int betalt;
		int modtaget;
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
					
					//UPDATE GUI MED KONTO
					
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
			spilgui.showMessage(felter[position].hentBeskedTekst()+ ". Tryk på ok.");
			regler.togFelt(aktivspiller);
			break;

		case 3://Fyrværkeri eller delfiner eller Café
			betalt = regler.fyrværkeriDelfinCafeFelt(aktivspiller, position);
			beskedstreng = felter[position].hentBeskedTekst() + betalt+"kr.";

			if (spiller[aktivspiller].erDuBankerot() == true) {
				beskedstreng = beskedstreng + ", og du gik desværre også bankerot. Spillet er færdigt";
			}	
			spilgui.showMessage(beskedstreng);			
			break;


		case 4://Onkel Mangepenges byttepenge

			modtaget = regler.onkelMangePengeFelt(aktivspiller);
			beskedstreng = felter[position].hentBeskedTekst() + modtaget;
			break;

		case 5://Gå på Cafe felt
			spilgui.showMessage(felter[position].hentBeskedTekst());
			regler.gåPåCafeFelt(aktivspiller, position);	
			kaldRegel(spiller, felter, aktivspiller, guispiller);
			
			break;

		case 6://START   SKAL DET IKKE HÅNDTERES SOM PROGRAM LOGIK ?
			regler.startFelt(aktivspiller);
			break;
		}
	}
}



