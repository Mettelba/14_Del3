import java.util.Random;

public class Terning {


	private int øjne;
	private int sider = 6;




	public int hentøjne() {
		return øjne;
	}


	public void sætøjne(int øjne) {
		this.øjne = øjne;
	}


	public int hentSider() {
		return sider;
	}


	public void sætSider(int sider) {
		this.sider = sider;
	}

	public Terning(int sider) {

		
	}

	public void kast() {
	
	Random tal = new Random();
	this.øjne = tal.nextInt(this.sider)+1;
	
		
		
	}
}
