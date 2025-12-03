package Assignment;

import java.awt.Color;
import hsa2.GraphicsConsole;

public class snowball {

	public static void main(String[] args) {
		new snowball();
	}

	final static int WINW = 800; // pixel
	final static int WINH = 600;
	final static int SLEEPTIME = 5; // ms

	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	hat h1, h2;

	snowball() {
		setup();


		// main game loop
		while(gc.getKeyCode() != 'Q') {
			moveHat(h1);
			moveHat(h2);
			drawGraphics();
			gc.sleep(SLEEPTIME);

		}

		gc.close();
	}

	void setup() {
		gc.setTitle("Two Ball Collosion");
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null);
		gc.setBackgroundColor(Color.BLACK);

		h1 = new hat(WINW);
		h2 = new hat(WINW); 


	}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(Color.WHITE);
			gc.setStroke(3);
			gc.drawRect(h1.x, h1.y, h1.size1, h1.size2);
			gc.drawRect(h2.x1, h2.y1, h2.size3, h2.size4);
		}
	}

	void moveHat(hat b) {
		b.y += b.vy; //b1.y = b1.y + by.vy;
		b.y1 += b.vy1; //b1.y = b1.y + by.vy;
		
		if (b.y < 80 || b.y1 < 80) {
			b.vy = -b.vy; 
			b.vy1 = -b.vy1;
		}
		if (b.y > 380 - b.size1 || b.y1 > 380 - b.size1) {
			b.vy = -b.vy; 
			b.vy1 = -b.vy1; 
		}
	}
}









