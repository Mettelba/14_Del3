
public class Konto {

	private int værdi;

	public Konto(int værdi) {					// Det man skriver i konstrukt�ren sker engang.

		this.værdi = værdi;				//Her s�tter jeg spillerens konto til 1000. *krav*
										//S�tter checkforminus til false, da der er 1000 p� konten.
	}

	public int hentVærdi() {
		return værdi;
	}

	public void sætVærdi(int værdi) {	

		this.værdi = værdi;  	// hvis ikke, lægger den værdien plus den nye v�rdi over i v�rdi.

	}

	public boolean checkMinus(int værdi) {

		if(this.værdi + værdi < 0 ) {		// Sp�rger om konto + v�rdi er mindre end 0, hvis ja 	
			this.værdi = 0;					// S�tter v�rdien til 0
			return true; 					// s�tter checkForMinus til at v�re true = tabt

		}
		return false;

	}
	public void indsæt(int værdi) {
		if(this.værdi + værdi < 0) {
			this.værdi = 0;

		}else {
			this.værdi = this.værdi + værdi;

		}

	}
	public boolean hæv(int hævetbeløb) {
		if (this.værdi - hævetbeløb < 0) {
			return false;
		}
		this.værdi = this.værdi - hævetbeløb;
		return true;
	}


}












