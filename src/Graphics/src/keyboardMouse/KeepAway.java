package keyboardMouse;
import java.awt.Color;
import hsa2.GraphicsConsole;

public class KeepAway {

	public static void main(String[] args) {
		new KeepAway();

	}

	static int winW = 900;  //static for easy access by Circle constructor
	static int winH = 800;

	GraphicsConsole gc = new GraphicsConsole(winW, winH);
	Circle c1 = new Circle();

	KeepAway(){
		setup();

		while(true) {
			if (gc.getKeyCode() == 'Q') break;	//quit if press Q
			if (checkCollision(c1))  break;		//game over
			moveCircle(c1);
			drawGraphics();
			gc.sleep(10);

		}
		//This is optional: wait a second and then close the window.
		gc.sleep(1000);
		gc.dispose();
	}


	void setup() {
		gc.setResizable(false);
		gc.setTitle("Keep Away - Don't Let the Mouse Touch the Circle!");
		gc.setLocationRelativeTo(null);
		gc.setAntiAlias(true);
		gc.setBackgroundColor(Color.BLACK);

		gc.enableMouseMotion();

	}

	boolean checkCollision(Circle c) {
		int mx = gc.getMouseX();
		int my = gc.getMouseY();

		if (c.contains(mx, my)) {
			c.vx *= -1;
			c.vy *= -1;
			return false;
		} else {
			return false;
		}
	}

	void moveCircle(Circle c) {

		c.x += c.vx;
		c.y += c.vy;

		//bounce off walls. We need to add a speed check to prevent circles from getting stuck on edges
		if (c.x < 0 && c.vx < 0) c.vx *= -1;
		if (c.y < 0 && c.vy < 0) c.vy *= -1;
		if (c.x+c.width  > winW && c.vx > 0) c.vx *= -1;
		if (c.y+c.height > winH && c.vy > 0) c.vy *= -1;
	}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(c1.colour);
			gc.fillOval(c1.x, c1.y, c1.width, c1.height);

		}	

	}
}
