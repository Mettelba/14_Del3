package Felter;

public class CafeFelt extends Felt {
	private int prisforkaffe;

	public CafeFelt (int feltnr, int pris, int husleje, int type, String ejerspillernavn, String farve, String felttekst, int prisforkaffe) {
		super (feltnr, pris, husleje, type, ejerspillernavn, farve, felttekst);
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
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejerspillernavn;
		returstreng = returstreng + "\n Super_farve = " + this.farve;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
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
	public int hentFelt() {
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

//	@Override
//	public boolean hentEkstraTur() {
//		return false;
//	}
//
//	@Override
//	public boolean sætFeltEjer() {
//		return false;
	}

