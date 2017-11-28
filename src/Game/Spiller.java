package Game;
public class Spiller {

	private String navn;
	private Konto konto = new Konto(31);
	private boolean bankerot = false;
	private int position = 0; //Starter på start.
	private boolean ekstraTur = false;


	protected Spiller() {
	}

	protected String hentNavn() {
		return this.navn;
	}

	protected void sætNavn(String navn) {
		this.navn = navn;
	}

	protected boolean erDuBankerot() {
		return this.bankerot;
	}

	protected int indeståendeSpillerKonto() {
		return konto.hentVærdi();
	}

	protected void indsætPåKonto(int værdi) {
		konto.indsæt(værdi);
	}

	protected void hævPåKonto(int værdi) {
		if (konto.checkMinus(værdi)==true) { //check om det vil give minus at hæve på kontoen, for så 
			bankerot = true; //bankerot = true
		}
		konto.hæv(værdi); //hæv penge på kontoen
	}

	protected int hentPosition() {
		return position;
	}

	protected void sætPosition(int position) {
		this.position = position;
	}

	protected boolean hentEkstraTur() {
		return ekstraTur;
	}

	protected void sætEkstraTur(boolean ekstraTur) {
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
