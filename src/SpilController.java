import Felter.*;
import gui_main.GUI;

public class SpilController {
	private boolean ekstratur = false;
	private boolean indkasseroverstart = true;
	private boolean vententur = false;
	private int type;
	private int feltnr;
	private int antalspillere;

	private Raflebæger raflebæger = new Raflebæger(6);

	private Spiller[] spiller;
	private Spilbræt spillebræt = new Spilbræt();
	private GUI spilgui = spillebræt.hentSpilGui();
	private Felt[] felter = spillebræt.hentSpilFelter();
		
	public SpilController(Spiller[] spiller) {

		this.spiller = spiller;

		


//		int felttype = spillebræt.hentType(position);
//		kaldRegel(felttype, spiller);
	}
	
	private Spiller spilsekvens(Spiller[] spiller) {
		raflebæger.ryst();
		spiller.sætPosition(spiller.hentPosition() + raflebæger.hentTerning1værdi());
		int position = spiller[1].hentPosition() + raflebæger.hentTerning1værdi();
		
		
		return spiller;
	}
		
	
	
	private void kaldRegel(int felttype, Spiller[] spiller, Felt[] felter) {

		
		//Håndter særregler for felter
		switch (felttype) {
		case 1://Normal felt
			System.out.println("Normal felt"+ felttype);
			break;
		case 2://Et tog
			this.ekstratur = felter[]
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



