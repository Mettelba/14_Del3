package Game;

import java.util.Scanner;

public class StartSpilController {

	
	public Spiller[] initialiserSpil() {
		String indtastetnavn;

		//Indtast antal spillere og deres navne
		Scanner sc = new Scanner(System.in);
		
		int antalspillere = 0;
		do {
		System.out.print("Indtast antal spillere fra 2 til 4: ");
		antalspillere = Integer.parseInt(sc.nextLine());
		System.out.println();

		} while (antalspillere < 1 || antalspillere > 4) ;
			

		//opret antalspillere + 1. Spiller0 er spillet.
		Spiller[] spiller = new Spiller[antalspillere+1];

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
		 return spiller; //giver referencen tilbage 
	}
}
