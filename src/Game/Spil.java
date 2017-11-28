package Game;

public class Spil {

	private SpilController monopolyspil;

	public static void main(String[] args) {

		Spil spil = new Spil();
		spil.monopolyspil = new SpilController();
		spil.monopolyspil.skiftSpiller();
	}


}
