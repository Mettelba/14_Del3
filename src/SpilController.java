import Felter.*;
import gui_main.GUI;

public class SpilController {

	private int felttype;
	private int feltnr;
	private int antalspillere;
	private int aktivspiller;

	private Spiller[] spiller;
	private Raflebæger raflebæger = new Raflebæger(6);
	private Spilbræt spillebræt;
	private GUI spilgui; 
	private Felt[] felter; 
	private SpilController spilkontrol;


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
		
		
		
		//GUI "Tryk på knappen for at slå terningerne.
		raflebæger.ryst();
		//Opdater GUI for terninger
		
		//sæt position for den aktive spiller i spillerarray
		this.spiller[this.aktivspiller].sætPosition(this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi());
		position = this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
		felttype = felter[position].hentFeltType();
		
		
		//Kald regler for felttype med felter og spiller
		kaldRegel(felttype, spiller, felter, aktivspiller, spilkontrol);
			
		
		
		
		//Opdater GUI for position
		
		
			
		return this.spiller;
	}
		
	
	
	private void kaldRegel(int felttype, Spiller[] spiller, Felt[] felter, int aktivspiller, SpilController spilkontrol) {

		
		//Håndter særregler for felter
		switch (felttype) {
		case 1://Normal felt
			System.out.println("Normal felt"+ felttype);
			break;
		case 2://Et tog
			//GUI BESKED "Du er landet på toget, og får derfor en ekstra tur. Tryk Ok.
			
			System.out.println("Et tog"+ felttype);
			break;
		case 3://Fyrværkeri eller delfiner
			System.out.println("Fyrværkeri eller delfiner"+felttype);
			break;
		case 4://Onkel Mangepenges byttepenge'
			System.out.println("Onkel Mangepenges byttepenge"+felttype);
			break;
		case 5://Cafe felt
			System.out.println("Cafe felt"+felttype);
			break;
		case 6://Gå på Cafe felt
			System.out.println("Gå på Cafe felt"+felttype);			
			break;
		case 7://Gå til
			System.out.println("Gå til"+felttype);
			break;
		case 8://START
			System.out.println("START"+felttype);
			break;

		}
		//Håndter generelle regler
	}
}



