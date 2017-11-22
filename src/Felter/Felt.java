package Felter;

public abstract class Felt {
	protected int feltnr;
	protected int pris;
	protected int type;
	protected int ejer = 0; //Spillet ejer alle felter fra starten.
	protected String beskedtekst;
	protected String felttekst;

	
	public Felt(int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst) {
		this.feltnr=feltnr;
		this.pris = pris;
		this.type = type;
		this.ejer = ejer;
		this.beskedtekst = beskedtekst;
		this.felttekst = felttekst;
	}

	public int hentFeltNr() {
		return this.feltnr;
	}
	
	public int hentPris() {
		return this.pris;
	}
	
	public int hentFeltType() {
		return this.type;
	}
	
	public int hentEjer() {
		return this.ejer;
	}
	
	public void sætEjer(int ejer) {
		this.ejer = ejer;
	}
	
	public String hentBeskedTekst() {
		return this.beskedtekst;
	}
	
	public String hentFeltTekst() {
		return this.felttekst;
	}
}

