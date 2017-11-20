package Game;

public class Raflebæger {

	private int antalsider;
	private int sum;
	private Terning terning1;
	private Terning terning2;
	private int terning1værdi;
	private int terning2værdi;

	

	public Raflebæger (int antalsider) {	
		this.antalsider = antalsider;
		terning1 = new Terning(this.antalsider);
		terning2 = new Terning(this.antalsider);
	}

 
	public int hentAntalsider() {
		return antalsider;
	}

 
	public void ryst() { 
		this.sum = 0;
		terning1.kast();
		terning2.kast();
		this.terning1værdi = this.terning1.hentØjne();	
		this.terning2værdi = this.terning2.hentØjne();
		this.sum = terning1.hentØjne() + terning2.hentØjne();	
	}  
	
	
	public int hentSum() {
		return this.sum;
	}
	
	
	public int hentTerning1værdi(){ 
		return terning1værdi;
 	}
	
	
	public int hentTerning2værdi() {
		return terning2værdi;
	}
	
	
	public void sætAntalsider(int antalsider) {
		this.antalsider = antalsider;

	}
	
	
	public void sætSum(int sum) {
		this.sum = sum;
	}
	
	
 	public void sætTerning1værdi(int terning1værdi) {
 		this.terning1værdi = terning1værdi;
 	}
	
 	
 	public void sætTerning2værdi(int terning2værdi) {
 		this.terning2værdi = terning2værdi;
 	}
	
 	
 	public String toString(){
		String returstreng;
		int sum;
		int antalsider; 
		Terning terning1;
		Terning terning2;
		int terning1værdi;
		int terning2værdi;

		sum = this.sum;
		antalsider = this.antalsider;
		terning1 = this.terning1;
		terning2 = this.terning2;
		terning1værdi = this.terning1værdi;
		terning2værdi = this.terning2værdi;


		returstreng = "sum er " +sum+ "antalsider er: " + antalsider + "terning1 er: " + terning1+"terning2 er: " + terning2+ "terning1værdi er: " + terning1værdi + "terning2værdi er: "+ terning2værdi;
		return  returstreng;


	}
	
}
