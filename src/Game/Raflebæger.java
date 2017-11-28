package Game;

public class Raflebæger {
	
	//FORBEREDT TIL 2 TERNINGER..
	
	private int antalsider;
//	private int sum;
	private Terning terning1;
//	private Terning terning2;
	private int terning1værdi;
//	private int terning2værdi;

	

	protected Raflebæger (int antalsider) {	
		this.antalsider = antalsider;
		terning1 = new Terning(this.antalsider);
//		terning2 = new Terning(this.antalsider);
	}

 
	protected int hentAntalsider() {
		return antalsider;
	}

 
	protected void ryst() { 
		this.terning1værdi = 0;
		terning1.kast();
//		terning2.kast();
		this.terning1værdi = this.terning1.hentØjne();	
//		this.terning2værdi = this.terning2.hentØjne();
//		this.sum = terning1.hentØjne() + terning2.hentØjne();
		this.terning1værdi = terning1.hentØjne();
	}  
	
	
//	protected int hentSum() {
//		return this.sum;
//	}
	
	
	protected int hentTerning1værdi(){ 
		return terning1værdi;
 	}
	
	
//	protected int hentTerning2værdi() {
//		return terning2værdi;
//	}
	
	
	protected void sætAntalsider(int antalsider) {
		this.antalsider = antalsider;

	}
	
	
//	protected void sætSum(int sum) {
//		this.sum = sum;
//	}
	
	
 	protected void sætTerning1værdi(int terning1værdi) {
 		this.terning1værdi = terning1værdi;
 	}
	
 	
// 	protected void sætTerning2værdi(int terning2værdi) {
// 		this.terning2værdi = terning2værdi;
// 	}
	
 	
 	public String toString(){
		String returstreng;
//		int sum;
		int antalsider; 
		Terning terning1;
//		Terning terning2;
		int terning1værdi;
//		int terning2værdi;

//		sum = this.sum;
		antalsider = this.antalsider;
		terning1 = this.terning1;
//		terning2 = this.terning2;
		terning1værdi = this.terning1værdi;
//		terning2værdi = this.terning2værdi;


		returstreng = "terning1værdi er " + terning1værdi + "antalsider er: " + antalsider + "terning1 er: " + terning1 + "terning1værdi er: " + terning1værdi;
		return  returstreng;


	}
	
}
