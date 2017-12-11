package Felter;

public class GåTilCafeFelt extends Felt{
	private int gåtilfeltnr; 

	public GåTilCafeFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int gåtilfeltnr) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.gåtilfeltnr = gåtilfeltnr;
	}

	public int landOnFelt() {
		return this.gåtilfeltnr;
	}
	
	
	public int hentGåTilFeltNr() {
		return this.gåtilfeltnr;
	}
	
	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_type = " + this.type;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
		returstreng = returstreng + "\n Super_beskedtekst = " + this.beskedtekst;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		returstreng = returstreng + "\n felt = " + this.gåtilfeltnr;
		return returstreng;
	}
}
