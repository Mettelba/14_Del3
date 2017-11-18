import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;
import Felter.*;
import java.util.Scanner;

public class Spil {

	private int antalspillere;
	private int antalbankerotspillere = 0;
	private int aktivspiller = 1;

	private Spiller[] spiller;
	private SpilController spilkontrol = new SpilController();
	private Scanner sc = new Scanner(System.in);



	public static void main(String[] args) {

		Spil monopolyspil = new Spil();
		
	}
	public void initialiserSpil() {
		String indtastetnavn;

		//Indtast antal spillere og deres navne
		System.out.print("Indtast antal spillere fra 1 til 4: ");
		antalspillere = sc.nextInt();
		System.out.println();

		if (antalspillere < 1 || antalspillere > 4) {
			return;
		}

		//opret antalspillere + 1. Spiller0 er spillet.
		spiller = new Spiller[antalspillere+1];

		//overfør spillernavne til spillerobjekter
		for (int i = 0; i<=antalspillere; i++) {
			spiller[i] = new Spiller();
		}

		// sætter spillernavne i spillerobjekterne
		for (int x=1 ; x<= antalspillere;x++) {
			System.out.print("Indtast navn på spiller "+ x +" :");
			indtastetnavn = sc.nextLine();
			System.out.println();
			spiller[x].sætNavn(indtastetnavn);
		}
	}

	public void skiftSpiller() {

		while (true) {

			//Check for antal spillere der er bankerot, hvis der kun er 1 tilbage så er spillet vundet.
			for (int y=1;y <= antalspillere ; y++) {
				if (spiller[y].erDuBankerot() == true ) {
					antalbankerotspillere++;
				}
				if (antalbankerotspillere == antalspillere-1) { // her er condition for while sætning.
					break;
				}


				// Kør spilsekvens hvis aktivspiller ikke er bankerot.
				while(spiller[aktivspiller].erDuBankerot() == false) {
					spiller = this.spilkontrol.spilsekvens(spiller, aktivspiller); //returner reference til spillerarray objekt efter spilsekvens
					

				}

			}
			aktivspiller++;

			//Hvis vi er nået til sidste spiller
			if (aktivspiller==antalspillere+1) {
				aktivspiller=1;

			}
		}
	}
}
