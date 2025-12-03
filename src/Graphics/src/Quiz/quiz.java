package Quiz;
/*
 * Isaac Tran
 * 2023-01-20
 * Mr. Campbell
 * 
 */
import java.awt.Color;
import java.awt.Rectangle;
import hsa2.GraphicsConsole;
public class quiz {

	public static void main(String[] args) {
		new quiz();
	}

	static final int WINW = 500;
	static final int WINH = 600;

	int x = 250, y = 300;
	int w = 10, h = w;

	static final int SPEED = 3;
	int vx, vy;

	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);

	quiz() {
		setup();

		while(gc.getKeyCode() != 'Q'){
			drawGraphics();
			enlarge();
			if (gc.getMouseButton(0)) {
				reduce();
			}
			gc.sleep(10);
		}
		gc.dispose();

	}
	void setup() {
		gc.setTitle("Click mouse to change motion. Press Q to quit");
		gc.setAntiAlias(true);
		gc.enableMouse();
		gc.enableMouseMotion();
		gc.setBackgroundColor(Color.BLACK);		
		gc.clear();			
		gc.setLocationRelativeTo(null);
		gc.setColor(Color.GREEN);
		gc.setStroke(4);
	}
	void enlarge(){

		y-=2;
		x-=2;
		w += 4;
		h += 4;

		if (x <= 0) {
			x = 250;
			y = 300;
			h = 10;
			w = h;
		}
	}

	void reduce() {	

		y += 4;
		x += 4;
		w -= 8;
		h -= 8;

		if (x >= 250) {
			x = 0;
			y = 50;
			w = 500;
			h = w;

			y += 8;
			x += 8;
			w -= 16;
			h -= 16;
		}
	}

	void drawGraphics() {
		gc.clear();
		gc.drawOval(x, y, w, h);
	}
}

