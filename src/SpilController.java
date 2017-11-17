import Felter.*;

public class SpilController {
	private boolean ekstratur = false;
	private boolean indkasseroverstart = true;
	private boolean vententur = false;
	private int type;
	private int feltnr;
	private int antalspillere;

	private Raflebæger raflebæger = new Raflebæger(6);
	
	private String[] spillernavne = new String[4];
	private Spiller[] spiller;
	private Spilbræt spillebræt = new Spilbræt();
		
	public SpilController(int antalspillere, String[] spillernavne) {

		this.spillernavne = spillernavne;
		this.antalspillere = antalspillere;
		this.spiller = new Spiller[this.antalspillere+1];
		
		for (int i = 0; i<=this.antalspillere; i++) {
			this.spiller[i] = new Spiller();
		}
			
		
		// sætter spillernavne i spillerobjekterne
		for (int x=1 ; x<= this.antalspillere;x++) {
			spiller[x].sætNavn(spillernavne[x-1]);
		}
		
		
		raflebæger.ryst();
		System.out.println("terningsum = " + raflebæger.hentTerning1værdi() + "spillerposition = "+spiller[1].hentPosition());
		spiller[0].sætPosition(spiller[1].hentPosition() + raflebæger.hentTerning1værdi());
		//kald GUI sæt position med spillernavn
		int position = spiller[1].hentPosition() + raflebæger.hentTerning1værdi();
		System.out.println(position);
		int felttype = spillebræt.hentType(position);
		kaldRegel(felttype);
		
	
	}
	
	private void kaldRegel(int felttype) {

		
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



