import java.awt.Color;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;
import Felter.*;

public class Spilbræt {

	private Felt[] felter = new Felt[24];	
	
	public Spilbræt() {
		initializeFields();
	}

	private void initializeFields() {	
		GUI gui = new GUI();
		GUI_Field[] f = new GUI_Field[24];
				
		felter[0] = new StartFelt(0, 1, 1, 8, "Spiller0", "Turkis", "START!", 2);
		GUI_Field a= new GUI_Street();
		a.setTitle(felter[0].hentFeltTekst());
		a.setBackGroundColor(Color.pink);
		f[0] = a;
		
		felter[1] = new NormalFelt(1, 1, 1, 1, "Spiller0", "blue", "Balkon boden", 2);	
		GUI_Field b= new GUI_Street();
		b.setTitle(felter[1].hentFeltTekst());
		b.setBackGroundColor(Color.blue);
		f[1] = b;
				
		felter[2] = new NormalFelt(2, 1, 1, 1, "Spiller0", "blue", "Candyfloss", 1);
		GUI_Field c= new GUI_Street();
		c.setTitle(felter[2].hentFeltTekst());
		c.setBackGroundColor(Color.blue);
		f[2] = c;
		
		felter[3] = new TogFelt(3, 1, 1, 2, "Spiller0", "yellow", "Du får en ekstra tur");
		GUI_Field d= new GUI_Street();
		d.setTitle(felter[3].hentFeltTekst());
		d.setBackGroundColor(Color.blue);
		f[3] = d;
		
		felter[4] = new NormalFelt(4, 2, 1, 1, "Spiller0", "yellow", "Dukkeforestillingen", 5);
		GUI_Field e= new GUI_Street();
		e.setTitle(felter[4].hentFeltTekst());
		e.setBackGroundColor(Color.blue);
		f[4] = e;
		
		felter[5] = new NormalFelt(5, 2, 1, 1, "Spiller0", "yellow", "Trylleshowet", 6);
		GUI_Field g= new GUI_Street();
		g.setTitle(felter[5].hentFeltTekst());
		g.setBackGroundColor(Color.blue);
		f[5] = g;
		
		felter[6] = new FyrværkeriEllerDelfinerFelt(6, 1, 1, 7, "Spiller0", "yellow", "Fyrværkeri", 2);
		GUI_Field h= new GUI_Street();
		h.setTitle(felter[6].hentFeltTekst());
		h.setBackGroundColor(Color.blue);
		f[6] = h;
		
		felter[7] = new NormalFelt(7, 1, 1, 1, "Spiller0", "yellow", "Teater", 8);
		GUI_Field i= new GUI_Street();
		i.setTitle(felter[7].hentFeltTekst());
		i.setBackGroundColor(Color.blue);
		f[7] = i;
		
		felter[8] = new NormalFelt(8, 1, 1, 1, "Spiller0", "yellow", "Legetøjsbutikken", 7);
		GUI_Field j= new GUI_Street();
		j.setTitle(felter[8].hentFeltTekst());
		j.setBackGroundColor(Color.blue);
		f[8] = j;
		
		felter[9] = new CafeFelt(9, 1, 1, 5, "Spiller0", "yellow", "Du går på cafe", 3);
		GUI_Field k= new GUI_Street();
		k.setTitle(felter[9].hentFeltTekst());
		k.setBackGroundColor(Color.blue);
		f[9] = k;
		
		felter[10] = new NormalFelt(10, 1, 1, 1, "Spiller0", "yellow", "Biografen", 11);
		GUI_Field l= new GUI_Street();
		l.setTitle(felter[10].hentFeltTekst());
		l.setBackGroundColor(Color.blue);
		f[10] = l;
		
		felter[11] = new NormalFelt(11 1, 1, 1, "Spiller0", "yellow", "Spillehallen", 10);
		GUI_Field m= new GUI_Street();
		m.setTitle(felter[11].hentFeltTekst());
		m.setBackGroundColor(Color.blue);
		f[11] = m;
		
		felter[12] = new OnkelMangePengeFelt(12, 1, 1, 1, "Spiller0", "yellow", "Onkel Mangepenge", 2);
		GUI_Field n= new GUI_Street();
		n.setTitle(felter[12].hentFeltTekst());
		n.setBackGroundColor(Color.blue);
		f[12] = n;
		
		felter[13] = new NormalFelt(13, 1, 1, 1, "Spiller0", "yellow", "Bowlinghallen", 14);
		GUI_Field o= new GUI_Street();
		o.setTitle(felter[13].hentFeltTekst());
		o.setBackGroundColor(Color.blue);
		f[13] = o;
		
		felter[14] = new NormalFelt(14 1, 1, 1, "Spiller0", "yellow", "Zoologisk have", 13);
		GUI_Field p= new GUI_Street();
		p.setTitle(felter[14].hentFeltTekst());
		p.setBackGroundColor(Color.blue);
		f[14] = p;
		
		felter[15] = new TogFelt(15, 1, 1, 2, "Spiller0", "yellow", "Du får en ekstra tur");
		GUI_Field q= new GUI_Street();
		q.setTitle(felter[15].hentFeltTekst());
		q.setBackGroundColor(Color.blue);
		f[15] = q;
		
		felter[16] = new NormalFelt(16, 1, 1, 1, "Spiller0", "yellow", "Vandlandet", 17);
		GUI_Field r= new GUI_Street();
		r.setTitle(felter[16].hentFeltTekst());
		r.setBackGroundColor(Color.blue);
		f[16] = r;
		
		felter[17] = new NormalFelt(17, 1, 1, 1, "Spiller0", "yellow", "Strandpromenaden", 16);
		GUI_Field s= new GUI_Street();
		s.setTitle(felter[17].hentFeltTekst());
		s.setBackGroundColor(Color.blue);
		f[17] = s;
		
		felter[18] = new FyrværkeriEllerDelfinerFelt(18, 1, 1, 7, "Spiller0", "yellow", "Delfiner", 2);
		GUI_Field t= new GUI_Street();
		t.setTitle(felter[18].hentFeltTekst());
		t.setBackGroundColor(Color.blue);
		f[18] = t;
		
		felter[19] = new NormalFelt(19, 1, 1, 1, "Spiller0", "yellow", "Pizzaria", 20);
		GUI_Field u= new GUI_Street();
		u.setTitle(felter[19].hentFeltTekst());
		u.setBackGroundColor(Color.blue);
		f[19] = u;
		
		felter[20] = new NormalFelt(20, 1, 1, 1, "Spiller0", "yellow", "Burgerbaren", 19);
		GUI_Field v= new GUI_Street();
		v.setTitle(felter[20].hentFeltTekst());
		v.setBackGroundColor(Color.blue);
		f[20] = v;
		
		felter[21] = new GåTilCafeFelt(21, 1, 1, 7, "Spiller0", "yellow", "Delfiner", 10);
		GUI_Field w= new GUI_Street();
		w.setTitle(felter[21].hentFeltTekst());
		w.setBackGroundColor(Color.blue);
		f[21] = w;
		
		felter[22] = new NormalFelt(22, 1, 1, 1, "Spiller0", "yellow", "Slikbutikken", 23);
		GUI_Field x= new GUI_Street();
		x.setTitle(felter[22].hentFeltTekst());
		x.setBackGroundColor(Color.blue);
		f[22] = x;
		
		felter[23] = new NormalFelt(23, 1, 1, 1, "Spiller0", "yellow", "Isboden", 22);
		GUI_Field y= new GUI_Street();
		y.setTitle(felter[23].hentFeltTekst());
		y.setBackGroundColor(Color.blue);
		f[23] = y;
		
	}
	
	public void opretSpilleBrætIGUI() {
		
		
	}
	
	public GUI hentSpilleBræt() {

		

		
		GUI_Field[] f = new GUI_Field[1];
		f[0] = g;
		new GUI(f);
		gui.showMessage("test");
		return gui;
	}

	public int hentType (int position) {
		int felttype;
		felttype = felter[position].hentType();
		return felttype;
	}
	
	
}
