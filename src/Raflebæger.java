
public class Raflebæger {

	private int antalsider;
	private Terning terning1;
	private int terning1værdi;

	

	public Raflebæger (int antalsider) {	
		
		this.antalsider = antalsider;
		terning1 = new Terning(this.antalsider);	
	}

 
	public int hentAntalsider() {
		return antalsider;
	}

 
	public void ryst() {
		this.terning1værdi = 0;
		
		terning1.kast();		
		
		this.terning1værdi = this.terning1.hentØjne();	
	}  
	
	
	public int hentTerning1værdi(){ 
		return terning1værdi;
 	}
	
	
	public void sætAntalsider(int antalsider) {
		this.antalsider = antalsider;

	}
	
	
 	public void sætTerning1værdi(int terning1værdi) {
 		this.terning1værdi = terning1værdi;
 	}
		
	
	
}
