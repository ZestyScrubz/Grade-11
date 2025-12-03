package BallAnimation;

import java.awt.Color;
import hsa2.GraphicsConsole;

public class TwoBalls {

	public static void main(String[] args) {
		new TwoBalls();
	}

	final static int WINW = 800; // pixel
	final static int WINH = 600;
	final static int SLEEPTIME = 5; // ms

	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	Ball b1, b2, b3;

	TwoBalls() {
		setup();


		// main game loop
		while(gc.getKeyCode() != 'Q') {
			moveBalls(b1);
			moveBalls(b2);
			moveBalls(b3);
			checkCollision();
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

		b1 = new Ball(WINW);
		b1.clr = Color.WHITE;
		b2 = new Ball(WINW); 
		b2.clr = Color.YELLOW;
		b3 = new Ball(WINW); 
		b3.clr = Color.BLUE;


		gc.setTitle(b1.x + ", " + b1.y);


	}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(b1.clr);
			gc.fillOval(b1.x, b1.y, b1.size, b1.size);
			gc.setColor(b2.clr);
			gc.fillOval(b2.x, b2.y, b2.size, b2.size);
			gc.setColor(b3.clr);
			gc.fillOval(b3.x, b3.y, b3.size, b3.size);
		}
	}

	void moveBalls(Ball b) {
		b.y += b.vy; //b1.y = b1.y + by.vy;

		if (b.y < 0) b.vy = -b.vy;
		if (b.y > WINH - b.size) b.vy = -b.vy; 

		b.y += b.vy; //b1.y = b1.y + by.vy;
	}
	void checkCollision() {
		if (b1.x > b2.x && b1.x < b2.x + b2.size) {
			if (b1.y > b2.y && b1.y < b2.y + b2.size) {
				// ball collide
				System.out.println("HIT");
			}
		}
	}
}









