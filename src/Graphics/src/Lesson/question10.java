package Lesson;

import java.awt.Color;
import hsa2.GraphicsConsole;

public class question10 {

	public static void main(String[] args) {
		new question10();

	}
	final static int WINW = 800; // pixel
	final static int WINH = 600;
	GraphicsConsole gc = new GraphicsConsole(WINW,WINH);
	Ball b1, b2;
	
	final static int BALLMOVE = 3;
	question10() {
		setup();
		
		gc.enableMouseMotion();
	
		
		while(gc.getKeyCode() != 'Q') {
			b1.x = gc.getMouseX();
			b1.y = gc.getMouseY();
			
			if (gc.isKeyDown(37)) {	//isKeyDown uses keyCodes. Left arrow
				if (b2.x > 0) b2.x -= BALLMOVE;
			}
			if (gc.isKeyDown(39)) { //right
				if (b2.x < 690) b2.x += BALLMOVE;
			}
			if (gc.isKeyDown(38)) {	//up
				if (b2.y > 0) b2.y -= BALLMOVE;
			}
			if (gc.isKeyDown(40)) {	//down
				if (b2.y < 490) b2.y += BALLMOVE;
			}
			drawGraphics();
			gc.setAntiAlias(true);
		}
		gc.sleep(3);
	}


	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(b1.clr);
			gc.fillOval(b1.x, b1.y, b1.size, b1.size);
			gc.setColor(b2.clr);
			gc.fillOval(b2.x, b2.y, b2.size, b2.size);
		}
	}
	void setup() {
		gc.setTitle("Two Ball Collosion");
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null);
		gc.setBackgroundColor(Color.BLACK);

		b1 = new Ball(WINW);
		b1.clr = Color.BLUE;
		b2 = new Ball(WINW); 
		b2.clr = Color.RED;


		gc.setTitle(b1.x + ", " + b1.y);


	}
}