import Felter.*;
import gui_main.GUI;

public class SpilController {

	private int felttype;
	private int feltnr;
	private int antalspillere;
	private int aktivspiller;

	private Spiller[] spiller;
	private Raflebæger raflebæger = new Raflebæger(6);
	private Spilbræt spillebræt = new Spilbræt();
	private GUI spilgui = spillebræt.hentSpilGui();
	private Felt[] felter = spillebræt.hentSpilFelter();


	public SpilController(Spiller[] spiller) {

//		int felttype = spillebræt.hentType(position);
//		kaldRegel(felttype, spiller);
	}
	
	public Spiller[] spilsekvens(Spiller[] spiller, int aktivspiller) {
		this.aktivspiller = aktivspiller;
		this.spiller = spiller;	
		raflebæger.ryst();
		
		//Opdater GUI for terninger
		
		//sæt position for den aktive spiller i spillerarray
		this.spiller[this.aktivspiller].sætPosition(this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi());
		int position = this.spiller[this.aktivspiller].hentPosition() + raflebæger.hentTerning1værdi();
		
		//Kald regler for position med felter og spiller
		
		
		//Opdater GUI for position
		
		
			
		return this.spiller;
	}
		
	
	
	private void kaldRegel(int felttype, Spiller[] spiller, Felt[] felter) {

		
		//Håndter særregler for felter
		switch (felttype) {
		case 1://Normal felt
			System.out.println("Normal felt"+ felttype);
			break;
		case 2://Et tog

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



