package graphics;
import hsa2.GraphicsConsole;
import java.awt.Color;

public class Bounce1 {
	public static void main(String[] args) {
		new Bounce1();
	}

	//Global variables
	GraphicsConsole gc = new GraphicsConsole(800 , 600);
	int ballx = 10, bally = 10; //location of ball
	int diameter = 40; //diameter of ball
	int xspeed = 3; // normally this is set to 2 or 3 pixels. Later, try 35
	int yspeed = xspeed;
	int sleepTime = 1; //controls speed of animation. Normally 1-10

	Bounce1() {
		setup();
		while(true) {

			moveAndDrawBall();
			gc.sleep(sleepTime);

		}
	}

	void setup() {
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null); //centre the window
		gc.setColor(Color.RED.darker() );
	}
	void moveAndDrawBall() {
		synchronized(gc) {
			gc.clearRect(ballx, bally, diameter, diameter);	
			ballx += xspeed;
			bally += yspeed;
			gc.fillOval(ballx, bally, diameter, diameter);
			
			int r = (int) (Math.random()* 255);
			int g = (int) (Math.random()* 255);
			int b = (int) (Math.random()* 255);
			
			if (bally >= 560) {
				yspeed *= -1;
				gc.setColor(new Color(r, g, b));
			}

			if (bally <= 0) {
				yspeed *= -1;
				gc.setColor(new Color(r, g, b));
			}

			if (ballx >= 760) {
				xspeed *= -1;
				gc.setColor(new Color(r, g, b));
			}

			if (ballx <= 0) {
				xspeed *= -1;
				gc.setColor(new Color(r, g, b));
			}
		}
	}
}