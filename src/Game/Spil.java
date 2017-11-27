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
	    StartSpilController startSpilController = new StartSpilController();
	    spiller = startSpilController.initialiserSpil();
	    

		spilkontrol = new SpilController(spiller);
		spilkontrol.skiftSpiller(antalspillere);
	}
}
