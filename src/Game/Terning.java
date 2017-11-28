package Game;
import java.util.Random;

public class Terning {


	private int øjne;
	private int sider = 3;


	protected Terning(int sider) {
		this.sider = sider;
	}

	protected void kast() { 
		Random tal = new Random();
		this.øjne = tal.nextInt(this.sider)+1;	//lave et randomtal mellem 1 og sider.
	}
	
	protected int hentØjne() { 
		return øjne;
	}

	protected int hentSider() {
		return sider;
	}
	
	protected void sætSider(int sider) {
		this.sider = sider;
	}
	
	protected void sætØjne(int øjne) {
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

