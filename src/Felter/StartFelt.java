package Felter;

public class StartFelt extends Felt{
	
	private int passerstart;
	
	public StartFelt (int feltnr, int pris, int husleje, int type, int ejer, String farve, String felttekst, int passerstart) {
		super (feltnr, pris, husleje, type, ejer, farve, felttekst);
		this.passerstart = passerstart;
	}
	
	@Override
	public int hentEjer() {
		return 0;
	}
	
	@Override
	public void sætEjer(int ejer) {
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
	public void sætOnkelsPenge(int penge) {
		// TODO Auto-generated method stub
		
	}

}
