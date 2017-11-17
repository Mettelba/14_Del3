import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Spil {

	private int antalspillere = 4;

	private String[] spillernavne = new String[4];
	private Spiller[] spiller;
	private SpilController spilkontrol = new SpilController();
	
	public static void main(String[] args) {

		Spil monopolyspil = new Spil();
		
		
		
		
		//	
		//	GUI_Field g= new GUI_Street();
		//	g.setTitle("Test");
		//	g.setBackGroundColor(Color.WHITE);
		//	
		//	GUI_Field[] f = new GUI_Field[1];
		//	f[0] = g;
		//	new GUI(f);
		//	gui.showMessage("test"); 

		Spilbræt spil = new Spilbræt();
	}
	
	public void spilSekvens() {
		//opret antalspillere + 1. Spiller0 er spillet.
		this.spiller = new Spiller[this.antalspillere+1];
		
		//overfør spillernavne til spillerobjekter
		for (int i = 0; i<=this.antalspillere; i++) {
			this.spiller[i] = new Spiller();
		}

		// sætter spillernavne i spillerobjekterne
		for (int x=1 ; x<= this.antalspillere;x++) {
			spiller[x].sætNavn(spillernavne[x-1]);
		}
		
		
		int x=1;
		while(spiller[x].erDuBankerot() == false || spiller[x].hentEkstraTur() == true) {
			SpilController(this.spiller[x]);
			
			
			x = x + 1;
		}
	}

}
