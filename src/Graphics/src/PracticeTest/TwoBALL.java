package PracticeTest;

import java.awt.Color;
import hsa2.GraphicsConsole;

public class TwoBALL {

	public static void main(String[] args) {
		new TwoBALL();
	}

	final static int WINW = 800; // pixel
	final static int WINH = 600;
	final static int SLEEPTIME = 5; // ms

	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	MovingBALL b1, b2, b3;
	final static int moveBalls = 5;

	TwoBALL() {
		setup();

		// main game loop
		while(gc.getKeyCode() != 'Q') {
			checkCollision();
			drawGraphics();
			if (enemy()) {
				
			}
			gc.sleep(SLEEPTIME);
			if (gc.getKeyChar() == 'a') {
				if (b1.x > 0) b1.x -= moveBalls;
			}
			if (gc.getKeyChar() == 'd') {
				if (b1.x < 690) b1.x += moveBalls;  //FIXME: ERROR: DO NOT USE MAGIC NUMBERS
			}
			if (gc.getKeyChar() == 'w') {
				if (b1.y > 0) b1.y -= moveBalls;
			}
			if (gc.getKeyChar() == 's') {
				if (b1.y < 490) b1.y += moveBalls;
			}

		}

		gc.close();
	}

	void setup() {
		gc.setTitle("Two Ball Collosion");
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null);
		gc.setBackgroundColor(Color.BLACK);

		b1 = new MovingBALL(WINW);
		b1.clr = Color.WHITE;
		b2 = new MovingBALL(WINW); 
		b2.clr = Color.YELLOW;
		b3 = new MovingBALL(WINW); 
		b3.clr = Color.BLUE;


		gc.setTitle(b1.x + ", " + b1.y);


	}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(b1.clr);
			gc.fillOval(b1.x, b1.y, b1.size, b1.size);
		}
	}
	
	boolean enemy() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(b2.clr);
			gc.fillOval(b2.x, b2.y, b2.size, b2.size);
		}
		return false;
	}

	void checkCollision() {
		if (b1.x > b2.x && b1.x < b2.x + b2.size) {
			if (b1.y > b2.y && b1.y < b2.y + b2.size) {
				// ball collide
				enemy();
				System.out.println("HIT");
			}
		}
	}
}









