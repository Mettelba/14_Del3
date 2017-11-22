package Felter;

public class StartFelt extends Felt{
	
	private int passerstart;
	
	public StartFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst, int passerstart) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);
		this.passerstart = passerstart;
	}
	
	

	public int hentPasserStart() {
		return this.passerstart;
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
//	@Override
//	public void sætOnkelsPenge(int penge) {
//		// TODO Auto-generated method stub
//		
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
