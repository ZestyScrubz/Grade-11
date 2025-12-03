package graphics;
import hsa2.GraphicsConsole;
import java.awt.Color;

public class Fading {
	public static void main(String[] args) {
		new Fading();
	}//end main
	
	GraphicsConsole gc = new GraphicsConsole (800, 600, "Spots");
	
	Fading(){
		//Setup section
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null); // centre window
		gc.setBackgroundColor(Color.GRAY);
		gc.setBackgroundColor(new Color(120, 120, 120, 10));
		gc.clear();
		gc.setColor(Color.RED);
		
		// animation variable
		int size = 40;
		int sleepTime = 5; // in milliseconds
		
		// animation loop
		while (true) {
			gc.clear();
			// make random number for location (800, 600)
			int rx = (int) ((Math.random()* 700) + 50 ); 
			int ry = (int) ((Math.random()* 500) + 50 ); 
			
			gc.fillOval(rx, ry, size, size);
			
			/*
			 * The Final thing in the loop should be 'sleep'.
			 * If it doesn't sleep the graphics may not be updated
			 */
			gc.sleep(sleepTime);
			
			// make random colour for next ball
			int r = (int) (Math.random()* 255);
			int g = (int) (Math.random()* 255);
			int b = (int) (Math.random()* 255);
			gc.setColor(new Color(r, g, b));
			
			// Here’s a special way to make brighter random colours:
			// gc.setColor(new Color(Color.HSBtoRGB((float)Math.random(), 1.0f, 1.0f)));
		}
	}//end constructor
	
} //end of class