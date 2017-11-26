package Game;
import java.util.Scanner;

public class Spil {

	private int antalspillere;

	private Spiller[] spiller;
	private SpilController spilkontrol;
	private Scanner sc = new Scanner(System.in);



	public static void main(String[] args) {

		Spil monopolyspil = new Spil();
		monopolyspil.initialiserSpil();
	}
	
	public void initialiserSpil() {
		String indtastetnavn;

		//Indtast antal spillere og deres navne
		System.out.print("Indtast antal spillere fra 1 til 4: ");
		antalspillere = Integer.parseInt(sc.nextLine());
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
		spilkontrol = new SpilController(spiller);
		spilkontrol.skiftSpiller(antalspillere);
	}
}
