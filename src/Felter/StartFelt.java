package Felter;

public class StartFelt extends Felt{
	
	private int passerstart;
	
	public StartFelt (int feltnr, int pris, int husleje, int type, String ejerspillernavn, String farve, String felttekst, int passerstart) {
		super (feltnr, pris, husleje, type, ejerspillernavn, farve, felttekst);
		this.passerstart = passerstart;
	}
	
	@Override
	public int hentPasserStart() {
		return this.passerstart;
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

}
