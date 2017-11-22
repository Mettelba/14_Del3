package Felter;

public class TogFelt extends Felt {
	
	private boolean ekstratur = true;
	
	public TogFelt (int feltnr, int pris, int type, int ejer, String beskedtekst, String felttekst) {
		super (feltnr, pris, type, ejer, beskedtekst, felttekst);

	}
	
	public boolean hentEkstraTur() {
		return this.ekstratur;
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
