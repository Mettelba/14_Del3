import java.awt.Color;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.*;
import Felter.*;

public class Spilbræt {


	//	gui.showMessage("test"); 

	private GUI_Field[] guifelter = new GUI_Field[24];
	private Felt[] felter = new Felt[24];	
	private GUI spilgui;

	public Spilbræt(Spiller[] spiller) {

		initialiserSpilBræt(spiller);
	}

	public GUI hentSpilGui() {
		GUI spilgui = new GUI(guifelter);
		return spilgui;
	}

	public Felt[] hentSpilFelter() {
		return felter;
	}

	private void initialiserSpilBræt(Spiller[] spiller) {	


		//Opretter datastruktur og GUI struktur for spillebrættet.
		felter[0] = new StartFelt(0, 1, 1, 7, 0, "Turkis", "START!", 2);
		GUI_Field a= new GUI_Street();
		a.setTitle(felter[0].hentFeltTekst());
		a.setBackGroundColor(Color.pink);
		guifelter[0] = a;

		felter[1] = new NormalFelt(1, 1, 1, 1, 0, "blue", "Balkon boden", 2, false);	
		GUI_Field b= new GUI_Street();
		b.setTitle(felter[1].hentFeltTekst());
		b.setBackGroundColor(Color.blue);
		guifelter[1] = b;

		felter[2] = new NormalFelt(2, 1, 1, 1, 0, "blue", "Candyfloss", 1, false);
		GUI_Field c= new GUI_Street();
		c.setTitle(felter[2].hentFeltTekst());
		c.setBackGroundColor(Color.blue);
		guifelter[2] = c;

		felter[3] = new TogFelt(3, 1, 1, 2, 0, "yellow", "Du får en ekstra tur");
		GUI_Field d= new GUI_Street();
		d.setTitle(felter[3].hentFeltTekst());
		d.setBackGroundColor(Color.pink);
		guifelter[3] = d;

		felter[4] = new NormalFelt(4, 2, 1, 1, 0, "yellow", "Dukkeforestillingen", 5,false);
		GUI_Field e= new GUI_Street();
		e.setTitle(felter[4].hentFeltTekst());
		e.setBackGroundColor(Color.gray);
		guifelter[4] = e;

		felter[5] = new NormalFelt(5, 2, 1, 1, 0, "yellow", "Trylleshowet", 6,false);
		GUI_Field g= new GUI_Street();
		g.setTitle(felter[5].hentFeltTekst());
		g.setBackGroundColor(Color.gray);
		guifelter[5] = g;

		felter[6] = new FyrværkeriEllerDelfinerFelt(6, 1, 1, 3, 0, "yellow", "Fyrværkeri", 2);
		GUI_Field h= new GUI_Street();
		h.setTitle(felter[6].hentFeltTekst());
		h.setBackGroundColor(Color.pink);
		guifelter[6] = h;

		felter[7] = new NormalFelt(7, 1, 1, 1, 0, "yellow", "Teater", 8,false);
		GUI_Field i= new GUI_Street();
		i.setTitle(felter[7].hentFeltTekst());
		i.setBackGroundColor(Color.red);
		guifelter[7] = i;

		felter[8] = new NormalFelt(8, 1, 1, 1, 0, "yellow", "Legetøjsbutikken", 7,false);
		GUI_Field j= new GUI_Street();
		j.setTitle(felter[8].hentFeltTekst());
		j.setBackGroundColor(Color.red);
		guifelter[8] = j;

		felter[9] = new CafeFelt(9, 1, 1, 5, 0, "yellow", "Du går på cafe", 3);
		GUI_Field k= new GUI_Street();
		k.setTitle(felter[9].hentFeltTekst());
		k.setBackGroundColor(Color.pink);
		guifelter[9] = k;

		felter[10] = new NormalFelt(10, 1, 1, 1, 0, "yellow", "Biografen", 11,false);
		GUI_Field l= new GUI_Street();
		l.setTitle(felter[10].hentFeltTekst());
		l.setBackGroundColor(Color.white);
		guifelter[10] = l;

		felter[11] = new NormalFelt(11, 1, 1, 1, 0, "yellow", "Spillehallen", 10,false);
		GUI_Field m= new GUI_Street();
		m.setTitle(felter[11].hentFeltTekst());
		m.setBackGroundColor(Color.white);
		guifelter[11] = m;

		felter[12] = new OnkelMangePengeFelt(12, 1, 1, 4, 0, "yellow", "Onkel Mangepenge", 2);
		GUI_Field n= new GUI_Street();
		n.setTitle(felter[12].hentFeltTekst());
		n.setBackGroundColor(Color.pink);
		guifelter[12] = n;

		felter[13] = new NormalFelt(13, 1, 1, 1, 0, "yellow", "Bowlinghallen", 14,false);
		GUI_Field o= new GUI_Street();
		o.setTitle(felter[13].hentFeltTekst());
		o.setBackGroundColor(Color.yellow);
		guifelter[13] = o;

		felter[14] = new NormalFelt(14, 1, 1, 1, 0, "yellow", "Zoologisk have", 13,false);
		GUI_Field p= new GUI_Street();
		p.setTitle(felter[14].hentFeltTekst());
		p.setBackGroundColor(Color.yellow);
		guifelter[14] = p;

		felter[15] = new TogFelt(15, 1, 1, 2, 0, "yellow", "Du får en ekstra tur");
		GUI_Field q= new GUI_Street();
		q.setTitle(felter[15].hentFeltTekst());
		q.setBackGroundColor(Color.pink);
		guifelter[15] = q;

		felter[16] = new NormalFelt(16, 1, 1, 1, 0, "yellow", "Vandlandet", 17,false);
		GUI_Field r= new GUI_Street();
		r.setTitle(felter[16].hentFeltTekst());
		r.setBackGroundColor(Color.orange);
		guifelter[16] = r;

		felter[17] = new NormalFelt(17, 1, 1, 1, 0, "yellow", "Strandpromenaden", 16,false);
		GUI_Field s= new GUI_Street();
		s.setTitle(felter[17].hentFeltTekst());
		s.setBackGroundColor(Color.orange);
		guifelter[17] = s;

		felter[18] = new FyrværkeriEllerDelfinerFelt(18, 1, 1, 3, 0, "yellow", "Du er taget til Delfinshow", 2);
		GUI_Field t= new GUI_Street();
		t.setTitle(felter[18].hentFeltTekst());
		t.setBackGroundColor(Color.pink);
		guifelter[18] = t;

		felter[19] = new NormalFelt(19, 1, 1, 1, 0, "yellow", "Pizzaria", 20,false);
		GUI_Field u= new GUI_Street();
		u.setTitle(felter[19].hentFeltTekst());
		u.setBackGroundColor(Color.cyan);
		guifelter[19] = u;

		felter[20] = new NormalFelt(20, 1, 1, 1, 0, "yellow", "Burgerbaren", 19,false);
		GUI_Field v= new GUI_Street();
		v.setTitle(felter[20].hentFeltTekst());
		v.setBackGroundColor(Color.cyan);
		guifelter[20] = v;

		felter[21] = new GåTilCafeFelt(21, 1, 1, 6, 0, "yellow", "Delfiner", 9);
		GUI_Field w= new GUI_Street();
		w.setTitle(felter[21].hentFeltTekst());
		w.setBackGroundColor(Color.pink);
		guifelter[21] = w;

		felter[22] = new NormalFelt(22, 1, 1, 1, 0, "yellow", "Slikbutikken", 23,false);
		GUI_Field x= new GUI_Street();
		x.setTitle(felter[22].hentFeltTekst());
		x.setBackGroundColor(Color.magenta);
		guifelter[22] = x;

		felter[23] = new NormalFelt(23, 1, 1, 1, 0, "yellow", "Isboden", 22,false);
		GUI_Field y= new GUI_Street();
		y.setTitle(felter[23].hentFeltTekst());
		y.setBackGroundColor(Color.magenta);
		guifelter[23] = y;



		//Laver biler


		//Opretter spillerne på brættet.
		//FULDSTÆNDIG TÅBELIG MÅDE AT HÅNDTERE DET PÅ I GUI!!!!
		//DEN TIDLIGERE VERSION VAR LAMGT BEDRE!!!!!
		int antalspillere = spiller.length;

		switch (antalspillere) {
		case 1:
			GUI_Player spiller1 = new GUI_Player(spiller[1].hentNavn(),spiller[1].indeståendeSpillerKonto());
			spilgui.addPlayer(spiller1);
			break;

		case 2:
			GUI_Player spiller2 = new GUI_Player(spiller[1].hentNavn(),spiller[1].indeståendeSpillerKonto());
			GUI_Player spiller3 = new GUI_Player(spiller[2].hentNavn(),spiller[2].indeståendeSpillerKonto());
			spilgui.addPlayer(spiller2);
			spilgui.addPlayer(spiller3);

			break;

		case 3:
			GUI_Player spiller4 = new GUI_Player(spiller[1].hentNavn(),spiller[1].indeståendeSpillerKonto());
			GUI_Player spiller5 = new GUI_Player(spiller[2].hentNavn(),spiller[2].indeståendeSpillerKonto());
			GUI_Player spiller6 = new GUI_Player(spiller[3].hentNavn(),spiller[3].indeståendeSpillerKonto());
			spilgui.addPlayer(spiller4);
			spilgui.addPlayer(spiller5);
			spilgui.addPlayer(spiller6);
			break;

		case 4:
			GUI_Player spiller7 = new GUI_Player(spiller[1].hentNavn(),spiller[1].indeståendeSpillerKonto());
			GUI_Player spiller8 = new GUI_Player(spiller[2].hentNavn(),spiller[2].indeståendeSpillerKonto());
			GUI_Player spiller9 = new GUI_Player(spiller[3].hentNavn(),spiller[3].indeståendeSpillerKonto());
			GUI_Player spiller10 = new GUI_Player(spiller[4].hentNavn(),spiller[4].indeståendeSpillerKonto());
			spilgui.addPlayer(spiller7);
			spilgui.addPlayer(spiller8);
			spilgui.addPlayer(spiller9);
			spilgui.addPlayer(spiller10);
			break;
		}
	}




	public int hentType (int position) {
		int felttype;
		felttype = felter[position].hentFeltType();
		return felttype;
	}


}
