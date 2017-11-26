package Felter;

public class StartFelt extends Felt{
	
	private int passerstart;
	
	public StartFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int passerstart) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.passerstart = passerstart;
	}
	
	

	public int hentPasserStart() {
		return this.passerstart;
	}

}
