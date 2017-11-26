package Felter;

public class EntreFelt extends Felt {
	private int prisforentre;

	public EntreFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int prisforkaffe) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.prisforentre = prisforkaffe;
	} 
	
	
	
	public int hentPrisForEntre() {
		return this.prisforentre;
	}

	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_ejer = " + this.ejer;
		returstreng = returstreng + "\n Super_tekst = " + this.beskedtekst;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		return returstreng;
	}
}

