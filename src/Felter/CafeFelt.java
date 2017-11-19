package Felter;

public class CafeFelt extends Felt {
	private int prisforkaffe;

	public CafeFelt (int feltnr, int pris, int husleje, int type, int ejer, String farve, String felttekst, int prisforkaffe) {
		super (feltnr, pris, husleje, type, ejer, farve, felttekst);
		this.prisforkaffe = prisforkaffe;
	} 
	
	public int hentPrisForKaffe() {
		return this.prisforkaffe;
	}

	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_husleje = " + this.husleje;
		returstreng = returstreng + "\n Super_ejer = " + this.ejer;
		returstreng = returstreng + "\n Super_farve = " + this.farve;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
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
	public int hentPasserStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hentPar() {
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
	public boolean hentBod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sætOnkelsPenge(int onkelspenge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sætBod(boolean bod) {
		// TODO Auto-generated method stub
		
	}
}

