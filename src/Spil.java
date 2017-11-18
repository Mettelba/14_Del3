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

	}
	public void initialiserSpil() {
		
		Spilbræt spilbræt = new Spilbræt();
		Felt[] felter = spilbræt.hentSpilFelter();
		GUI gui = spilbræt.hentSpilGui();
		
		
		//opret antalspillere + 1. Spiller0 er spillet.
		spiller = new Spiller[antalspillere+1];
		
		//overfør spillernavne til spillerobjekter
		for (int i = 0; i<=antalspillere; i++) {
			spiller[i] = new Spiller();
		}

		// sætter spillernavne i spillerobjekterne
		for (int x=1 ; x<= antalspillere;x++) {
			spiller[x].sætNavn(spillernavne[x-1]);
		}
	}
	
	
	public void spilSekvens() {
		
		int x=1;
		while(spiller[x].erDuBankerot() == false || spiller[x].hentEkstraTur() == true) {
			spilkontrol(this.spiller, x);
			
			
			x = x + 1;
		}
	}

}
