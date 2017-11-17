import java.util.Random;

public class Terning {


	private int øjne;
	private int sider = 6;


	public Terning(int sider) {
		this.sider = sider;
	}


	public void kast() { 
		Random tal = new Random();
		this.øjne = tal.nextInt(this.sider)+1;	
	}
	
	
	public int hentøjne() { 
		return øjne;
	}


	public int hentSider() {
		return sider;
	}
	
	
	public void sætSider(int sider) {
		this.sider = sider;
	}
	
	
	public void sætøjne(int øjne) {
		this.øjne = øjne;
	}
	
	public String toString() {
		String returstreng;
		int øjne;
		int sider;
		
		øjne=this.øjne;
		sider = this.sider;
		
		returstreng= "øjne = "+øjne;
		returstreng= returstreng + "\n  sider = "+sider;
		
		return returstreng;
		}
	
	
}

