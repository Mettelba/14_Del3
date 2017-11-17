package Felter;

public class GåTilCafeFelt extends Felt{
	private int felt;

	public GåTilCafeFelt (int feltnr, int pris, int husleje, int type, String ejerspillernavn, String farve, String felttekst, int felt) {
		super (feltnr, pris, husleje, type, ejerspillernavn, farve, felttekst);
		this.felt = felt;
	}

	@Override
	public int hentFelt() {
		return this.felt;
	}
	
	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_husleje = " + this.husleje;
		returstreng = returstreng + "\n Super_type = " + this.type;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejerspillernavn;
		returstreng = returstreng + "\n Super_farve = " + this.farve;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		returstreng = returstreng + "\n felt = " + this.felt;
		return returstreng;
	}

	@Override
	public boolean hentEkstraTur() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sætFeltEjer(String spillernavn) {
		// TODO Auto-generated method stub
		
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
	public int hentPar() {
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
}
