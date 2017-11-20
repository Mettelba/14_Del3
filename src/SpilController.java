import Felter.*;
import gui_main.GUI;

public class SpilController {

	private int feltnr;
	private int antalspillere;
	private int aktivspiller;

	private Spiller[] spiller;
	private Raflebæger raflebæger = new Raflebæger(6);
	private Spilbræt spillebræt;
	private GUI spilgui; 
	private Felt[] felter; 
	private SpilController spilkontrol;
	private Regler regler = new Regler(spiller, felter, aktivspiller);


	public SpilController(Spiller[] spiller) {
		
		spillebræt = new Spilbræt(spiller);
		spilgui = spillebræt.hentSpilGui();
		felter = spillebræt.hentSpilFelter();
		
		
//		int felttype = spillebræt.hentType(position);
//		kaldRegel(felttype, spiller);
	}
	
	public Spiller[] spilsekvens(Spiller[] spiller, int aktivspiller, SpilController spilkontrol) {
		this.aktivspiller = aktivspiller;
		this.spiller = spiller;	
		int position;
		int felttype;
		
		
		
		//GUI "Tryk på knappen for at slå terningerne.
		raflebæger.ryst();
		//Opdater GUI for terninger
		
		//sæt position for den aktive spiller i spillerarray
		this.spiller[this.aktivspiller].sætPosition(this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi());
		position = this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
		felttype = felter[position].hentFeltType();
		
		
		//Kald regler for felttype med felter og spiller
		kaldRegel(felttype, spiller, felter, aktivspiller, spilkontrol);
			
		
		
		
		//Opdater GUI for positioN	
		return this.spiller;
	}
		
	
	
	private void kaldRegel(int felttype, Spiller[] spiller, Felt[] felter, int aktivspiller, SpilController spilkontrol) {

		
		//Håndter særregler for felter
		switch (felttype) {
		case 1://Normal felt
			regler.normalFelt(aktivspiller);
			break;
		case 2://Et tog
			//GUI BESKED "Du er landet på toget, og får derfor en ekstra tur. Tryk Ok.
			regler.togFelt(aktivspiller);
			break;
		case 3://Fyrværkeri eller delfiner eller Café
			regler.fyrværkeriDelfinCafeFelt(aktivspiller);
			break;
		case 4://Onkel Mangepenges byttepenge'
			regler.onkelMangePengeFelt(aktivspiller);
			break;
		case 5://Gå på Cafe felt
			regler.gåPåCafeFelt(aktivspiller);	
			break;
		case 6://START   SKAL DET IKKE HÅNDTERES SOM PROGRAM LOGIK ?
			regler.startFelt(aktivspiller);
			break;
		}
	}
}



