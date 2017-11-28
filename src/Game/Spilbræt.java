package Game;
import java.awt.Color;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.*;
import Felter.*;

public class Spilbræt {

	private GUI_Field[] guifelter; 
	private Felt[] felter = new Felt[24];	
	private GUI spilgui;
	private GUI_Player[] guispiller;
	private GUI_Car[] guibil= new GUI_Car[5];
	private Color[] bilfarve = new Color[5];
	
	public Spilbræt(Spiller[] spiller) {
		initialiserSpilBræt(spiller);
	}

	public GUI hentSpilGui() {
		return spilgui;
	}

	public Felt[] hentSpilFelter() {
		return felter;
	}
	 
	public GUI_Player[] hentGUISpiller() {
		return guispiller;
	}
	
	public GUI_Field[] hentGUIfelter() {
		return guifelter;
	}

	private void initialiserSpilBræt(Spiller[] spiller) {	
		guifelter = new GUI_Field[24];
		int antalspillere = spiller.length;
		guispiller = new GUI_Player[antalspillere];

		//Opretter datastruktur og GUI struktur for spillebrættet.
		felter[0] = new StartFelt(0, 0, 6, 0, "Du har passeret start og får ", "START!", 2);
		GUI_Field a= new GUI_Street();
		a.setTitle(felter[0].hentFeltTekst());
		a.setBackGroundColor(Color.pink);
		a.setSubText("");
		guifelter[0] = a;

		felter[1] = new NormalFelt(1, 1, 1, 0, "Du står på Balkon boden", "Balkon boden", 2);	
		GUI_Field b= new GUI_Street();
		b.setTitle(felter[1].hentFeltTekst());
		b.setBackGroundColor(Color.blue);
		b.setSubText("Pris: " + String.valueOf(felter[1].hentPris()) + " Kr");
		guifelter[1] = b;

		felter[2] = new NormalFelt(2, 1, 1, 0, "Du står på Candyfloss Paladset", "Candyfloss Paladset", 1);
		GUI_Field c= new GUI_Street();
		c.setTitle(felter[2].hentFeltTekst());
		c.setBackGroundColor(Color.blue);
		c.setSubText("Pris: " + String.valueOf(felter[2].hentPris())+ " Kr ");
		guifelter[2] = c;

		felter[3] = new TogFelt(3, 0, 2, 0, "Du tager toget og får en ekstra tur", "TogFelt");
		GUI_Field d= new GUI_Street();
		d.setTitle(felter[3].hentFeltTekst());
		d.setBackGroundColor(Color.pink);
		d.setSubText("");
		guifelter[3] = d;

		felter[4] = new NormalFelt(4, 2, 1, 0, "Du er landet på dukketeatret", "Dukketeatret", 5);
		GUI_Field e= new GUI_Street();
		e.setTitle(felter[4].hentFeltTekst());
		e.setBackGroundColor(Color.gray);
		e.setSubText("Pris: " + String.valueOf(felter[4].hentPris())+ " Kr");
		guifelter[4] = e;

		felter[5] = new NormalFelt(5, 2, 1, 0, "Du er landet på trylleshowet", "Trylleshowet", 4);
		GUI_Field g= new GUI_Street();
		g.setTitle(felter[5].hentFeltTekst());
		g.setBackGroundColor(Color.gray);
		g.setSubText("Pris: " + String.valueOf(felter[5].hentPris())+ " Kr");
		guifelter[5] = g;

		felter[6] = new EntreFelt(6, 0, 3, 0, "Du er gået ind og se fyrværkeri og det koster ", "Fyrværkeri", 2);
		GUI_Field h= new GUI_Street();
		h.setTitle(felter[6].hentFeltTekst());
		h.setBackGroundColor(Color.pink);
		h.setSubText("Entre: " + String.valueOf(((EntreFelt)felter[6]).hentPrisForEntre()) + " Kr.");
		guifelter[6] = h;

		felter[7] = new NormalFelt(7, 2, 1, 0, "Du er landet på teatret", "Teater", 8);
		GUI_Field i= new GUI_Street();
		i.setTitle(felter[7].hentFeltTekst());
		i.setBackGroundColor(Color.red);
		i.setSubText("Pris: " + String.valueOf(felter[7].hentPris())+ " Kr");
		guifelter[7] = i;

		felter[8] = new NormalFelt(8, 2, 1, 0, "Du er landet i legetøjsbutikken", "Legetøjsbutikken", 7);
		GUI_Field j= new GUI_Street();
		j.setTitle(felter[8].hentFeltTekst());
		j.setBackGroundColor(Color.red);
		j.setSubText("Pris: " + String.valueOf(felter[8].hentPris())+ " Kr");
		guifelter[8] = j;

		felter[9] = new EntreFelt(9, 0, 3, 0, "Du går på café og det koster ", "Du går på cafe", 3);
		GUI_Field k= new GUI_Street();
		k.setTitle(felter[9].hentFeltTekst());
		k.setBackGroundColor(Color.pink);
		k.setSubText("Entre: " + String.valueOf(((EntreFelt)felter[9]).hentPrisForEntre()) + " Kr.");
		guifelter[9] = k;

		felter[10] = new NormalFelt(10, 3, 1, 0, "Du er landet i biografen", "Biografen", 11);
		GUI_Field l= new GUI_Street();
		l.setTitle(felter[10].hentFeltTekst());
		l.setBackGroundColor(Color.white);
		l.setSubText("Pris: " + String.valueOf(felter[10].hentPris())+ " Kr");
		guifelter[10] = l;

		felter[11] = new NormalFelt(11, 3, 1, 0, "Du er landet i spillehallen", "Spillehallen", 10);
		GUI_Field m= new GUI_Street();
		m.setTitle(felter[11].hentFeltTekst());
		m.setBackGroundColor(Color.white);
		m.setSubText("Pris: " + String.valueOf(felter[10].hentPris()) + " Kr");
		guifelter[11] = m;

		felter[12] = new OnkelMangePengeFelt(12, 0, 4, 0, "Du er på besøg hos Onkel Mangepenge, og han giver dig det han har i lommen. Du får ", "Onkel Mangepenge", 2);
		GUI_Field n= new GUI_Street();
		n.setTitle(felter[12].hentFeltTekst());
		n.setBackGroundColor(Color.pink);
		n.setSubText(String.valueOf(((OnkelMangePengeFelt)felter[12]).hentOnkelsPenge()) + " Kr.");
		guifelter[12] = n;

		felter[13] = new NormalFelt(13, 3, 1, 0, "Du er landet i bowlinghallen", "Bowlinghallen", 14);
		GUI_Field o= new GUI_Street();
		o.setTitle(felter[13].hentFeltTekst());
		o.setBackGroundColor(Color.yellow);
		o.setSubText("Pris: " + String.valueOf(felter[13].hentPris())+ " Kr");
		guifelter[13] = o;

		felter[14] = new NormalFelt(14, 3, 1, 0, "Du er landet i zoologisk have", "Zoologisk have", 13);
		GUI_Field p= new GUI_Street();
		p.setTitle(felter[14].hentFeltTekst());
		p.setBackGroundColor(Color.yellow);
		p.setSubText("Pris: " + String.valueOf(felter[14].hentPris())+ " Kr");
		guifelter[14] = p;

		felter[15] = new TogFelt(15, 0, 2, 0, "Du tager toget og får en ekstra tur.", "Togfelt");
		GUI_Field q= new GUI_Street();
		q.setTitle(felter[15].hentFeltTekst());
		q.setBackGroundColor(Color.pink);
		q.setSubText("");
		guifelter[15] = q;

		felter[16] = new NormalFelt(16, 4, 1, 0, "Du er landet i vandlandet", "Vandlandet", 17);
		GUI_Field r= new GUI_Street();
		r.setTitle(felter[16].hentFeltTekst());
		r.setBackGroundColor(Color.orange);
		r.setSubText("Pris: " + String.valueOf(felter[16].hentPris())+ " Kr");
		guifelter[16] = r;

		felter[17] = new NormalFelt(17, 4, 1, 0, "Du er landet på strandpromenaden", "Strandpromenaden", 16);
		GUI_Field s= new GUI_Street();
		s.setTitle(felter[17].hentFeltTekst());
		s.setBackGroundColor(Color.orange);
		s.setSubText("Pris: " + String.valueOf(felter[17].hentPris()) + " Kr");
		guifelter[17] = s;

		
		felter[18] = new EntreFelt(18, 0, 3, 0, "Du er taget til delfinshow og det koster ", "Delfinshow", 2);
		GUI_Field t= new GUI_Street();
		t.setTitle(felter[18].hentFeltTekst());
		t.setBackGroundColor(Color.pink);
		t.setSubText("Entre: " + String.valueOf(((EntreFelt)felter[18]).hentPrisForEntre()) + " Kr.");
		guifelter[18] = t;

		felter[19] = new NormalFelt(19, 4, 1, 0, "Du er landet på pizzariaet", "Pizzaria", 20);
		GUI_Field u= new GUI_Street();
		u.setTitle(felter[19].hentFeltTekst());
		u.setBackGroundColor(Color.cyan);
		u.setSubText("Pris: " + String.valueOf(felter[19].hentPris()) + " Kr");
		guifelter[19] = u;

		felter[20] = new NormalFelt(20, 4, 1, 0, "Du er landet på burgerbaren", "Burgerbaren", 19);
		GUI_Field v= new GUI_Street();
		v.setTitle(felter[20].hentFeltTekst());
		v.setBackGroundColor(Color.cyan);
		v.setSubText("Pris: " + String.valueOf(felter[20].hentPris())+ " Kr");
		guifelter[20] = v;

		felter[21] = new GåTilCafeFelt(21, 0, 5, 0, "Din ven har ringet for at få dig med på Cafe. Du tager derhen", "Gå til Caféen", 9);
		GUI_Field w= new GUI_Street();
		w.setTitle(felter[21].hentFeltTekst());
		w.setBackGroundColor(Color.pink);
		w.setSubText("");
		guifelter[21] = w;

		felter[22] = new NormalFelt(22, 6, 1, 0, "Du er landet i slikbutikken.", "Slikbutikken", 23);
		GUI_Field x= new GUI_Street();
		x.setTitle(felter[22].hentFeltTekst());
		x.setBackGroundColor(Color.magenta);
		x.setSubText("Pris: " + String.valueOf(felter[22].hentPris()) + " Kr");
		guifelter[22] = x;

		felter[23] = new NormalFelt(23, 6, 1, 0, "Du er landet i isboden.", "Isboden", 22);
		GUI_Field y= new GUI_Street();
		y.setTitle(felter[23].hentFeltTekst());
		y.setBackGroundColor(Color.magenta);
		y.setSubText("Pris: " + String.valueOf(felter[23].hentPris())+ " Kr");
		guifelter[23] = y;

		spilgui = new GUI(guifelter);

		//Opretter 4 farver på bilerne
		
			bilfarve[1] = new Color(70,250,0);
			bilfarve[2] = new Color(10,160,230);
			bilfarve[3] = new Color(200,200,200);
			bilfarve[4] = new Color(0,0,0);
		
		
		//Opretter spillerne på brættet.

		for (int tæller = 1;tæller< antalspillere;tæller++) {
			guibil[tæller] = new GUI_Car();
			guibil[tæller].setPrimaryColor(bilfarve[tæller]);
			guispiller[tæller] = new GUI_Player(spiller[tæller].hentNavn(),spiller[tæller].indeståendeSpillerKonto(),guibil[tæller]);

			spilgui.addPlayer(guispiller[tæller]);
		}

		//Sæt spiller op på start
		for (int tæller = 1; tæller < antalspillere;tæller++) {
		spilgui.getFields()[spiller[tæller].hentPosition()].setCar(guispiller[tæller], true);
		}
		
		spilgui.showMessage("velkommen til BørneMonopoly.");
		
	}


	public int hentType (int position) {
		int felttype;
		felttype = felter[position].hentFeltType();
		return felttype;
	}
}
