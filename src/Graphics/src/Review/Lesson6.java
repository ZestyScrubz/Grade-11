package Review;
import java.awt.Color;
import hsa2.GraphicsConsole;

public class Lesson6 {
	
	public static void main(String[] args) {
		new Lesson6();
	}
	
	static int WINW = 800, WINH = 800;
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	Ball b1, b2;
	
	final static int BALLSPEED = 3;

	Lesson6(){
		setup();
		
		gc.enableMouseMotion();
		
		while(gc.getKeyCode() != 'Q') {
			b1.x = gc.getMouseX();
			b1.y = gc.getMouseY();
			
			if(gc.isKeyDown(38)) { //up
				if (b2.y > 0) b2.y -= BALLSPEED;
			}
			if(gc.isKeyDown(40)) { //down
				if (b2.y < 780) b2.y += BALLSPEED;
			}
			if(gc.isKeyDown(37)) { //left
				if (b2.x > 0) b2.x -= BALLSPEED;
			}
			if(gc.isKeyDown(39)) { //right
				if (b2.x < 780) b2.x += BALLSPEED;
			}
			
			drawGraphics();
		}
	}
	
	void setup(){
		gc.setTitle("Two Ball Collosion");
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null);
		gc.setBackgroundColor(Color.BLACK);
		
		b1 = new Ball();
		b1.clr = Color.BLUE;
		b2 = new Ball(); 
		b2.clr = Color.RED;
	}
	
	void drawGraphics() {
		synchronized(gc){
			gc.clear();
			gc.setColor(b1.clr);
			gc.fillOval(b1.x, b1.y, b1.size, b1.size);
			gc.setColor(b2.clr);
			gc.fillOval(b2.x, b2.y, b2.size, b2.size);

		}
	}
}
