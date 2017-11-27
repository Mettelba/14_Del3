package Game;
public class Spiller {

	private String navn;
	private Konto konto = new Konto(31);
	private boolean bankerot = false;
	private int position = 0; //Starter på start.
	private boolean ekstraTur = false;


	public Spiller() {
	}

	public String hentNavn() {
		return this.navn;
	}

	public void sætNavn(String navn) {
		this.navn = navn;
	}


//	public void modtagGevinst(int værdi) {
//		if (konto.checkMinus(værdi)) {
//			bankerot = true;
//		} else {
//			konto.indsæt(værdi);
//		}
//	}

	public boolean erDuBankerot() {
		return this.bankerot;
	}

	public int indeståendeSpillerKonto() {
		return konto.hentVærdi();
	}

	public void indsætPåKonto(int værdi) {
		konto.indsæt(værdi);
	}

	public void hævPåKonto(int værdi) {
		if (konto.checkMinus(værdi)==true) {
			bankerot = true;
		}
		konto.hæv(værdi);
	}

	public int hentPosition() {
		return position;
	}

	public void sætPosition(int position) {
		this.position = position;
	}

	public boolean hentEkstraTur() {
		return ekstraTur;
	}

	public void sætEkstraTur(boolean ekstraTur) {
		this.ekstraTur = ekstraTur;
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

}
