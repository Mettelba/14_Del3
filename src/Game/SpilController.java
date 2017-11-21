package Game;
import Felter.*;
import gui_main.*;




public class SpilController {

	private int feltnr;
	private int antalspillere;
	private int aktivspiller;

	private Spiller[] spiller;
	private Raflebæger raflebæger = new Raflebæger(3);
	private Spilbræt spillebræt;
	private GUI spilgui;

	private Felt[] felter; 

	private RegelController regler; 


	public SpilController(Spiller[] spiller) {

		spillebræt = new Spilbræt(spiller);
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		regler = new RegelController(spiller, felter);

	}

	public Spiller[] spilsekvens(Spiller[] spiller, int aktivspiller) {
		this.aktivspiller = aktivspiller;
		this.spiller = spiller;	
		int position;
		int felttype;

		do {
		spilgui.showMessage("Tryk på OK for at rulle terningerner");
		raflebæger.ryst();
		//Set terninger i GUI
		spilgui.setDice(raflebæger.hentTerning1værdi(), 1,1, raflebæger.hentTerning2værdi(), 1, 2);//Opdater GUI for terninger

		//sæt position for den aktive spiller i spillerarray
		this.spiller[this.aktivspiller].sætPosition(this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi());
		position = this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();

		
		
		//Kald regler for felttype med felter og spiller
		kaldRegel(spiller, felter, aktivspiller);

		//Opdater GUI for position
		}while (spiller[aktivspiller].hentEkstraTur() == true);
		return this.spiller;
	}



	private void kaldRegel(Spiller[] spiller, Felt[] felter, int aktivspiller) {
		int position = spiller[aktivspiller].hentPosition();
		int felttype = felter[position].hentFeltType();
		int feltejer = felter[position].hentEjer();
		int betalt;
		int modtaget;
		String beskedstreng;
		
		//Særregler for felter
		switch (felttype) {
		case 1://Normal felt
    		//Her kan du så få lov at købe grunden hvis du vil.
			//GUI besked vil du købe grunden ja/nej.
			if (feltejer == 0 && spiller[aktivspiller].indeståendeSpillerKonto() > felter[position].hentPris()) {//har aktivspiller råd til at købe det.
				spilgui.showMessage(felter[position].hentBeskedTekst()+" og den er til salg. vil du købe grunden?");	
			regler.normalFeltKøbGrund(aktivspiller, position);
			}
			
			//Felt er ejet af en anden spiller og det ikke er spiller 0
			if (feltejer != aktivspiller && feltejer != 0) {
				betalt = regler.normalFeltEjetAfAnden(aktivspiller, position);
				
				beskedstreng = felter[position].hentBeskedTekst() + ", og den er ejet af " + spiller[felter[felter[position].hentPar()].hentEjer()] + "Du skal betale " + betalt;
				
				if (spiller[aktivspiller].erDuBankerot() == true) {
					beskedstreng = beskedstreng + ", og du gik desværre også bankerot. Spillet er færdigt";
				}
				spilgui.showMessage(beskedstreng);
			}
			
		case 2://Et tog
			spilgui.showMessage(felter[position].hentBeskedTekst()+ ". Tryk på ok.");
			regler.togFelt(aktivspiller);
			break;
			
		case 3://Fyrværkeri eller delfiner eller Café
			betalt = regler.fyrværkeriDelfinCafeFelt(aktivspiller, position);
			beskedstreng = felter[position].hentBeskedTekst() + " og skal betale " + betalt;
			
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
			
			regler.gåPåCafeFelt(aktivspiller, position);	
			kaldRegel(spiller, felter, aktivspiller);
			break;
			
		case 6://START   SKAL DET IKKE HÅNDTERES SOM PROGRAM LOGIK ?
			regler.startFelt(aktivspiller);
			break;
		}
	}
}



