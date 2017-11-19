package Felter;

public abstract class Felt {
	protected int feltnr;
	protected int pris;
	protected int husleje;
	protected int type;
	protected String ejerspillernavn;
	protected String farve;
	protected String felttekst;

	public Felt(int feltnr, int pris, int husleje, int type, String ejerspillernavn, String farve, String felttekst) {
		this.feltnr=feltnr;
		this.pris = pris;
		this.husleje = husleje;
		this.type = type;
		this.ejerspillernavn = ejerspillernavn;
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
	
	public String hentEjerSpillerNavn() {
		return this.ejerspillernavn;
	}
	
	public void sætEjerSpillerNavn(String ejerspillernavn) {
		this.ejerspillernavn = ejerspillernavn;
	}
	
	public String hentFarve() {
		return this.farve;
	}
	
	public String hentFeltTekst() {
		return this.felttekst;
	}
	
	public abstract boolean hentEkstraTur();
	public abstract int hentPrisForKaffe();
	public abstract int hentPasserStart();
	public abstract int hentPar();
	public abstract int hentGåTilFeltNr();
	public abstract int hentEntre();
	public abstract int hentOnkelsPenge();
	public abstract void sætOnkelsPenge();
	
	}





