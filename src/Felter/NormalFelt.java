package Felter;

public class NormalFelt extends Felt {
	private int par;
	
	public NormalFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int par, boolean bod) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.par = par;
	}

	public int hentPar() {
		return this.par;
	}
	

	

	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_type = " + this.type;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
		returstreng = returstreng + "\n Super_beskedtekst = " + this.beskedtekst;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		returstreng = returstreng + "\n par = " + this.par;
		return returstreng;
	}
}

