package Felter;

public class NormalFelt extends Felt {
	private int par;
	private boolean bod;//Der er ingen boder på nogen felter fra starten.
	
	public NormalFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int par, boolean bod) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.par = par;
		this.bod = bod;
	}
	
	
	
	public int hentPar() {
		return this.par;
	}
	

	

	public String toString() {
		String returstreng;
		returstreng = "Super_feltnr = " + this.feltnr;
		returstreng = returstreng + "\n Super_pris = " + this.pris;
		returstreng = returstreng + "\n Super_type = " + this.type;
		returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
		returstreng = returstreng + "\n Super_beskedtekst = " + this.beskedtekst;
		returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
		returstreng = returstreng + "\n par = " + this.par;
		return returstreng;
	}

	
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
//
//	@Override
//	public int hentFeltNr() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int hentOnkelsPenge() {
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
//
//
//	@Override
//	public void sætOnkelsPenge(int onkelspenge) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public int hentPrisForEntre() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}

