package Felter;

public class TogFelt extends Felt {
	
	private boolean ekstratur = true;
	
	public TogFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);

	}
	
	
	public boolean hentEkstraTur() {
		return this.ekstratur;
	}
}
