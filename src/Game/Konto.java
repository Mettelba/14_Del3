package Game;

public class Konto {

	private int værdi;

	protected Konto(int værdi) {			
		this.værdi = værdi;			
	}

	protected int hentVærdi() {
		return værdi;
	}

	protected void sætVærdi(int værdi) {	
		this.værdi = værdi;

	}

	protected boolean checkMinus(int værdi) {
		if(this.værdi - værdi < 0 ) {		// Spørger om konto - værdi er mindre end 0, hvis ja 	
			return true; 					// returner true
		}else {
			return false;					// eller false
		}
	}
	
	protected boolean indsæt(int værdi) {
		if(værdi < 0) {					// Er værdi der blive indsat en minus værdi så returner false.
			return false;
		}else {
			this.værdi = this.værdi + værdi; // ellers indsæt værdi på kontoen
			return true; // returner true
		}
	}
	
	protected boolean hæv(int hævetbeløb) {
		if (hævetbeløb < 0 || this.værdi - hævetbeløb < 0) { //Hvis hævet beløb er minus, eller der ikke er nok penge på kontoen
			this.værdi = 0;//Sæt konto til 0 kr.
			return false; //returner false
		}else {
			this.værdi = this.værdi - hævetbeløb; //ellers hæv penge på kontoen 
			return true;//returner true.
		}
	}


}












