import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Spil {
	
	public static void main(String[] args) {
	GUI gui = new GUI();
	GUI_Field g= new GUI_Street();
	g.setTitle("Test");
	g.setBackGroundColor(Color.WHITE);
	GUI_Field[] f = new GUI_Field[1];
	f[0] = g;
	new GUI(f);
	gui.showMessage("test"); 
	
	}

}
