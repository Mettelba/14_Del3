import java.util.*;

import Felter.*;

public class Spilbræt {

	private Felt[] felter = new Felt[13];	
	
	public Spilbræt() {
		initializeFields();
	}

	private void initializeFields() {		
		felter[0] = new NormalFelt(0, 1, 1, 1, "Spiller0", "yellow", "bliver ikke brugt", 0);
		felter[1] = new StartFelt(1, 1, 1, 8, "Spiller0", "Turkis", "START!", 2);
		felter[2] = new NormalFelt(2, 1, 1, 1, "Spiller0", "blue", "Balkon boden", 3);
		felter[3] = new NormalFelt(3, 1, 1, 1, "Spiller0", "blue", "Candyfloss", 2);
		felter[4] = new TogFelt(4, 1, 1, 2, "Spiller0", "yellow", "Du får en ekstra tur");
		felter[5] = new NormalFelt(5, 2, 1, 1, "Spiller0", "yellow", "Dukkeforestillingen", 6);
		felter[6] = new NormalFelt(6, 2, 1, 1, "Spiller0", "yellow", "Trylleshowet", 5);
		felter[7] = new FyrværkeriEllerDelfinerFelt(7, 1, 1, 7, "Spiller0", "yellow", "Fyrværkeri", 2);
		felter[8] = new NormalFelt(8, 1, 1, 1, "Spiller0", "yellow", "Teater", 9);
		felter[9] = new NormalFelt(9, 1, 1, 1, "Spiller0", "yellow", "Legetøjsbutikken", 8);
		felter[10] = new CafeFelt(10, 1, 1, 5, "Spiller0", "yellow", "Du går på cafe", 3);
		felter[11] = new NormalFelt(11, 1, 1, 1, "Spiller0", "yellow", "Biografen", 12);
		felter[12] = new NormalFelt(12, 1, 1, 1, "Spiller0", "yellow", "Spillehallen", 11);
		felter[13] = new OnkelMangePengeFelt(13, 1, 1, 1, "Spiller0", "yellow", "Spillehallen", 2);
		felter[14] = new NormalFelt(14, 1, 1, 1, "Spiller0", "yellow", "Bowlinghallen", 15);
		felter[15] = new NormalFelt(15, 1, 1, 1, "Spiller0", "yellow", "Zoologisk have", 14);
		felter[16] = new TogFelt(16, 1, 1, 2, "Spiller0", "yellow", "Du får en ekstra tur");
		felter[17] = new NormalFelt(17, 1, 1, 1, "Spiller0", "yellow", "Vandlandet", 18);
		felter[18] = new NormalFelt(18, 1, 1, 1, "Spiller0", "yellow", "Strandpromenaden", 17);
		felter[19] = new FyrværkeriEllerDelfinerFelt(19, 1, 1, 7, "Spiller0", "yellow", "Delfiner", 2);
		felter[20] = new NormalFelt(20, 1, 1, 1, "Spiller0", "yellow", "Pizzaria", 21);
		felter[21] = new NormalFelt(21, 1, 1, 1, "Spiller0", "yellow", "Burgerbaren", 20);
		felter[22] = new GåTilCafeFelt(22, 1, 1, 7, "Spiller0", "yellow", "Delfiner", 10);
		felter[23] = new NormalFelt(23, 1, 1, 1, "Spiller0", "yellow", "Slikbutikken", 24);
		felter[24] = new NormalFelt(24, 1, 1, 1, "Spiller0", "yellow", "Isboden", 23);
		
	}
	
	public void opretSpilleBrætIBUI() {
		
		
	}

	public int hentType (int position) {
		int felttype;
		felttype = felter[position].hentType();
		return felttype;
	}
	
	
}
