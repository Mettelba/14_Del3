package Felter;

public class NormalFelt extends Felt {
	private int par;
	private boolean bod;//Der er ingen boder på nogen felter fra starten.
	
	public NormalFelt (int feltnr, int pris, int husleje, int type, int ejer, String farve, String felttekst, int par, boolean bod) {
		super (feltnr, pris, husleje, type, ejer, farve, felttekst);
		this.par = par;
		this.bod = bod;
	}
	
	
	@Override
	public int hentPar() {
		return this.par;
	}
	
	@Override
	public boolean hentBod() {
		return this.bod;
	}
	
	@Override
	public void sætBod(boolean bod) {
		this.bod = bod;
	}
	
	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_husleje = " + this.husleje;
		returstreng = returstreng + "\n Super_type = " + this.type;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
		returstreng = returstreng + "\n Super_farve = " + this.farve;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		returstreng = returstreng + "\n par = " + this.par;
		return returstreng;
	}

	@Override
	public int hentEjer() {
		return 0;
	}
	
	@Override
	public void sætEjer(int ejer) {
	}
	
	@Override
	public boolean hentEkstraTur() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int hentPrisForKaffe() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int hentPasserStart() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int hentFeltNr() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int hentEntre() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int hentOnkelsPenge() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int hentGåTilFeltNr() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void sætOnkelsPenge(int onkelspenge) {
		// TODO Auto-generated method stub
		
	}
}

