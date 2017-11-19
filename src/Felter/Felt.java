package Felter;

public abstract class Felt {
	protected int feltnr;
	protected int pris;
	protected int husleje;
	protected int type;
	protected int ejer = 0; //Spillet ejer alle felter fra starten.
	protected String farve;
	protected String felttekst;

	public Felt(int feltnr, int pris, int husleje, int type, int ejer, String farve, String felttekst) {
		this.feltnr=feltnr;
		this.pris = pris;
		this.husleje = husleje;
		this.type = type;
		this.ejer = ejer;
		this.farve = farve;
		this.felttekst = felttekst;
	}

	public int hentFeltNr() {
		return this.feltnr;
	}
	
	public int hentPris() {
		return this.pris;
	}
	
	public int hentHusleje() {
		return this.husleje;
	}
	
	public void sætHusLeje(int husleje) {
		this.husleje = husleje;
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
	
	public String hentFarve() {
		return this.farve;
	}
	
	public String hentFeltTekst() {
		return this.felttekst;
	}
	
	public abstract boolean hentEkstraTur();
	public abstract void sætOnkelsPenge(int onkelspenge);
	public abstract int hentPrisForKaffe();
	public abstract int hentPasserStart();
	public abstract int hentPar();
	public abstract int hentGåTilFeltNr();
	public abstract int hentEntre();
	public abstract int hentOnkelsPenge();
	public abstract boolean hentBod();
	public abstract void sætBod(boolean bod);
}

