package Felter;

	public class FyrværkeriEllerDelfinerFelt extends Felt {
		private int pris;
		
		public FyrværkeriEllerDelfinerFelt (int feltnr, int pris, int husleje, int type, int ejer, String beskedtekst, String felttekst, int par) {
			super (feltnr, pris, husleje, type, ejer, beskedtekst, felttekst);
			this.pris = pris; 
		}
		
		
		
		@Override
		public int hentPrisForEntre() {
			return this.pris;
		}
		public String toString() {
			String returstreng;
			returstreng = "Super_feltnr = " + this.feltnr;
			returstreng = returstreng + "\n Super_pris = " + this.pris;
			returstreng = returstreng + "\n Super_husleje = " + this.husleje;
			returstreng = returstreng + "\n Super_type = " + this.type;
			returstreng = returstreng + "\n Super_ejerspillernavn = " + this.ejer;
			returstreng = returstreng + "\n Super_beskedtekst = " + this.beskedtekst;
			returstreng = returstreng + "\n Super_felttekst = " + this.felttekst;
			returstreng = returstreng + "\n par = " + this.pris;
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
		public int hentFeltType() {
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
