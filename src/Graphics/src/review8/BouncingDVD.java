package review8;
import java.awt.Font;
import java.awt.Color;
import java.util.*;
import hsa2.GraphicsConsole;

public class BouncingDVD {

	public static void main(String[] args) {
		new BouncingDVD();
	}

	static int WINW = 900;
	static int WINH = 600;
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	ArrayList<DVD> logo = new ArrayList<DVD>();
	
	BouncingDVD(){
		setup();
		
		while(true){
			// move each logo
			for (DVD d : logo) {
				moveLogo(d);
			}
			
			// detect mouse click and +/-
				// add new logo
			if (gc.getMouseButton(0) && gc.getMouseClick() > 0) logo.add(new DVD());
				// remove logo
			if (gc.getMouseButton(2) && gc.getMouseClick() > 0) {
				if (logo.size() > 0) logo.remove(0);
			}
			
			if (gc.getKeyChar() == '+') for (DVD d : logo) d.increaseSize();	//make logo bigger
			if (gc.getKeyChar() == '-') for (DVD d : logo) d.decreaseSize();	//make logo smaller
			
			drawGraphics();
			gc.sleep(10);
		}
	}
	
	void setup() {
		gc.setResizable(false);
		gc.setTitle("Bouncing DVD Symbol");
		gc.setLocationRelativeTo(null);
		gc.setAntiAlias(true);
		gc.setBackgroundColor(Color.WHITE);
		
		gc.enableMouse();
		
		//Instantiate the DVD objects and add to list
		logo.add(new DVD());
	}
	
	void moveLogo(DVD d) {
		d.x += d.vx;
		d.y += d.vy;
		
		//bounce off walls. We need to add a speed check to prevent DVD logo from getting stuck on edges
		if (d.x < 0 && d.vx < 0) {
			d.vx *= -1;
		}
		if (d.y - d.size < 0 && d.vy < 0) {
			d.vy *= -1;
		}
		if (d.x+(2*d.size)  > WINW && d.vx > 0) {
			d.vx *= -1;
		}
		if (d.y > WINH && d.vy > 0) {
			d.vy *= -1;
		}
	}
	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			for (DVD d : logo) {
				gc.setFont(new Font("Times New Roman", Font.BOLD, d.size));
				gc.drawString("DVD", d.x, d.y);
			}
		}
	}

}
