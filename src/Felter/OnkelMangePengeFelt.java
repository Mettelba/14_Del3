package Felter;

public class OnkelMangePengeFelt extends Felt {
	private int onkelspenge;

	public OnkelMangePengeFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int onkelspenge) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.onkelspenge = onkelspenge;
	}
	
	
	public int hentOnkelsPenge() {
		return this.onkelspenge;
	}
	
	public void sætOnkelsPenge(int onkelspenge) {
		this.onkelspenge = onkelspenge;
	}

	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
		returstreng = returstreng + "\n Super_farve = " + this.beskedtekst;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		return returstreng;
	}
}
