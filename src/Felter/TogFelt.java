package Felter;

public class TogFelt extends Felt {
	
	private boolean ekstratur = true;
	
	public TogFelt (int feltnr, int pris, int husleje, int type, String ejerspillernavn, String farve, String felttekst) {
		super (feltnr, pris, husleje, type, ejerspillernavn, farve, felttekst);

	}
	
	@Override
	public boolean hentEkstraTur() {
		return this.ekstratur;
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
