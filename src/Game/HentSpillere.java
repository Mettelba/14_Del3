package Game;

import java.util.Scanner;

public class HentSpillere {
	private int antalspillere = 0;
	private String indtastetnavn;
	private Spiller[] spiller;
	private String input;
		
	protected Spiller[] hentSpillere() {

		//Indtast antal spillere og deres navne
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Indtast antal spillere fra 2 til 4: ");
			input = sc.nextLine();
			if (input.charAt(0) >= '2' && input.charAt(0) <= '4') { //Hvis der ikke er indtastet 2-4 så skal der ikke laves spillere

				antalspillere = Integer.parseInt(input);
				System.out.println();
			}
		} while (antalspillere < 2 || antalspillere > 4) ; // bliv i dette loop sålænge der ikke er indtastet 2-4 

		//opret spiller til at kunne indeholde antalspillere+1 objektreferencer. Spiller 0 er spillet.
		spiller = new Spiller[antalspillere+1];

		//opret spillerobjekterne
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
		sc.close();
		return spiller; //giver referencen tilbage 
	}

	protected int hentAntalSpillere() {
		return this.antalspillere;
	}

}
