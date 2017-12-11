package Felter;

public class TogFelt extends Felt {
	
	private int ekstratur = 1;
	
	public TogFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);

	}
	public int landOnFelt() {
		/* 0 = ingen ekstratur
		 * 1 = ekstratur
		 */
		
		return this.ekstratur;
	}
//	public boolean hentEkstraTur() {
//		return this.ekstratur;
//	}
}
