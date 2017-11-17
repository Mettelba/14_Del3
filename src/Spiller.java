public class Spiller {

	private String navn = "Player0";
	private Konto konto = new Konto(31);
	private boolean bankerot = false;
	private int position = 1;
	

	public Spiller() {
	}

	public String hentNavn() {
		return this.navn;
	}

	public void sætNavn(String navn) {
		this.navn = navn;
	}


	public void modtagGevinst(int værdi) {
		if (konto.checkMinus(værdi)==true) {
			bankerot = true;
		} else {
			String spiltekst = konto.indsæt(værdi);
		}
	}

	public boolean erDuBankerot() {
		return this.bankerot;
	}

	public int indestæendeSpillerKonto() {
		return konto.hentVærdi();
	}

	public void sætKontoVærdi(int værdi) {
		konto.sætVærdi(værdi);
	}

	public void hævKontoVærdi(int værdi) {
		konto.hæv(værdi);
	}
	public String toString() {
		String returstreng;
		String navn = " ";
		Konto konto;
		boolean bankerot = false;
		
		navn = this.navn;
		konto = this.konto;
		bankerot = this.bankerot;
		
		returstreng = "navn = " + navn + "\n   konto = " + konto + "\n   bankerot = "+ bankerot;
		
		return returstreng;
	}

	public int hentPosition() {
		return position;
	}

	public void sætPosition(int position) {
		this.position = position;
	}
	
}
