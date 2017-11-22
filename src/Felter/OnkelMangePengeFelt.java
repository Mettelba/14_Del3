package Felter;

public class OnkelMangePengeFelt extends Felt {
	private int onkelspenge;

	public OnkelMangePengeFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int onkelspenge) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.onkelspenge = onkelspenge;
	}
	
	
	public int hentOnkelsPenge() {
		return this.onkelspenge;
	}
	
	public void sætOnkelsPenge(int onkelspenge) {
		this.onkelspenge = onkelspenge;
	}

	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
		returstreng = returstreng + "\n Super_farve = " + this.beskedtekst;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		return returstreng;
	}

//	@Override
//	public int hentEjer() {
//		return 0;
//	}
//	
//	@Override
//	public void sætEjer(int ejer) {
//	}
//	
//	@Override
//	public boolean hentEkstraTur() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public int hentPasserStart() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int hentPar() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int hentFeltNr() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	@Override
//	public int hentGåTilFeltNr() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean hentBod() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void sætBod(boolean bod) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int hentPrisForEntre() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
