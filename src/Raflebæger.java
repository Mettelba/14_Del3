
public class Raflebæger {

	private int sum;
	private int antalsider;
	private Terning terning1;
	private Terning terning2;
	

	public void raflebæger (int antalsider) {	
		
		this.antalsider = antalsider;
		terning1 = new Terning(this.antalsider);
		terning2 = new Terning(this.antalsider);
		
		
	}


	public int hentAntalsider() {
		return antalsider;

	}


	public void sætAntalsider(int antalsider) {
		this.antalsider = antalsider;

	}


	public int hentSum() {
		sum = terning1.hentøjne() + terning2.hentøjne();
		return sum;
		

	}


	public void sætSum(int sum) {
		this.sum = sum;

	}

	public void ryst() {
		this.sum = 0;
		
		terning1.kast();		
		terning2.kast();
		
		sum = this.terning1.hentøjne() + this.terning2.hentøjne();
		
		
		
	}
	//en metode der henter værdien fra terning1 
		public int hentTerning1værdi () {
			return terning1.hentøjne();
			}
		
		//en metode der henter værdien fra terning1 
		public int hentTerning2værdi () {
			return terning2.hentøjne();
		}
	
}
