package Assignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;

import hsa2.GraphicsConsole;

public class snowfall {

	public static void main(String[] args) {
		new snowfall();
	}

	final static int WINW = 1000; // pixel
	final static int WINH = 800;
	final static int SLEEPTIME = 1; // controls speed of animation in ms
	
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	Snow b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19; // snow flakes variable
	hat h1, h2; // hat variable
	
	snowfall() {
		setup(); // run the setup
		drawing(); // run the drawing

		// main game loop
		while(gc.getKeyCode() != 'Q') {
			moveBalls(b1); // each one is to move the snow flake
			moveBalls(b2);
			moveBalls(b3);
			moveBalls(b4);
			moveBalls(b5);
			moveBalls(b6);
			moveBalls(b7);
			moveBalls(b8);
			moveBalls(b9);
			moveBalls(b10);
			moveBalls(b11);
			moveBalls(b12);
			moveBalls(b13);
			moveBalls(b14);
			moveBalls(b15);
			moveBalls(b16);
			moveBalls(b17);
			moveBalls(b18);
			moveBalls(b19);
			moveHat(h1); // move hat pieces
			moveHat(h2);
			drawGraphics(); // run drawGraphics
			gc.sleep(SLEEPTIME);

		}
		gc.close();
	}

	void setup() {
		synchronized(gc) {
			gc.setTitle("A Winter Day");
			gc.setAntiAlias(true);
			gc.setLocationRelativeTo(null); // center the screen

			b1 = new Snow(WINW); // each one creates a location of the snow flake
			b2 = new Snow(WINW); 
			b3 = new Snow(WINW); 
			b4 = new Snow(WINW); 
			b5 = new Snow(WINW); 
			b6 = new Snow(WINW); 
			b7 = new Snow(WINW); 
			b8 =  new Snow(WINW); 
			b9 = new Snow(WINW); 
			b10 = new Snow(WINW); 
			b11 = new Snow(WINW); 
			b12 = new Snow(WINW); 
			b13 = new Snow(WINW); 
			b14 = new Snow(WINW); 
			b15 = new Snow(WINW); 
			b16 = new Snow(WINW); 
			b17 = new Snow(WINW); 
			b18 = new Snow(WINW); 
			b19 = new Snow(WINW); 
			
			h1 = new hat(WINW); // location of hat
			h2 = new hat(WINW); 
		}
	}
	
	void drawing() {
		// new colours
		Color SKYBLUE = new Color (80, 170, 248);
		Color BROWN = new Color (185, 122, 87);
		Color GREEN = new Color (34, 177, 76);
		Color TreeGreen = new Color(34, 177, 76, 115);

		// new font
		Font myFont = new Font("Informal Roman", Font.PLAIN, 48);
		// set background
		gc.setBackgroundColor(SKYBLUE);
		gc.clear();
		
		// create triangle for nose 
		Polygon nose = new Polygon();
		nose.addPoint(550, 280);
		nose.addPoint(550, 290);
		nose.addPoint(480, 280);

		// create triangles for the tree
		Polygon botTree = new Polygon();
		botTree.addPoint(750, 470);
		botTree.addPoint(880, 470);
		botTree.addPoint(815, 340);
		Polygon midTree = new Polygon();
		midTree.addPoint(750, 420);
		midTree.addPoint(880, 420);
		midTree.addPoint(815, 300);
		Polygon topTree = new Polygon();
		topTree.addPoint(750, 370);
		topTree.addPoint(880, 370);
		topTree.addPoint(815, 260);

		// the ground
		gc.setColor(BROWN);
		gc.fillRect(0, 600, 1000, 100);
		gc.setColor(GREEN);
		gc.fillRect(0, 580, 1000, 30);
		gc.setColor(Color.WHITE);
		gc.fillRect(0, 570, 1000, 10);

		// the snowman's body
		gc.setColor(Color.WHITE);
		gc.fillOval(460, 400, 180, 180);
		gc.fillOval(485, 300, 130, 130);
		gc.fillOval(500, 220, 100, 100);

		// the snowman's arms
		gc.setColor(BROWN);
		gc.setStroke(8);
		gc.drawLine(450, 300, 485, 360);
		gc.drawLine(680, 330, 615, 360);
		gc.setStroke(3);
		gc.drawLine(450, 300, 455, 280);// left fingers
		gc.drawLine(450, 300, 440, 285);
		gc.drawLine(450, 300, 430, 295);
		gc.drawLine(680, 330, 685, 310);// right finger
		gc.drawLine(680, 330, 700, 320);
		gc.drawLine(680, 330, 700, 340);

		// the snowman's eyes
		gc.setColor(Color.BLACK);
		gc.drawOval(520, 250, 15, 15);
		gc.setColor(Color.BLACK);
		gc.drawOval(560, 250, 15, 15);

		// the snowman's nose
		gc.setColor(Color.ORANGE);
		gc.setStroke(4);
		gc.drawPolygon(nose);

		// the TREE
		gc.setColor(BROWN);
		gc.fillRect(795, 470, 40, 100);
		gc.setColor(TreeGreen);
		gc.fillPolygon(botTree);
		gc.fillPolygon(midTree);
		gc.fillPolygon(topTree);

		// clouds
		gc.setColor(Color.WHITE);
		gc.fillOval(130, 40, 110, 70); //cloud 1
		gc.fillOval(180, 20, 90, 65);
		gc.fillOval(460, 50, 110, 75);// cloud 2
		gc.fillOval(410, 70, 110, 70);
		gc.fillOval(480, 70, 115, 68);
		gc.fillOval(710, 70, 115, 78);// cloud 3
		gc.fillOval(750, 80, 115, 68);
		gc.fillOval(750, 30, 115, 90);
		gc.fillOval(800, 63, 115, 78);

		// text
		gc.setFont(myFont);
		gc.drawString("Mr. SnowMan", 50, 250);
		gc.setFont(new Font("Bahnschrift", Font.ITALIC, 18));
		gc.drawString("By Isaac Tran", 50, 300);
		
		}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear(); //clear screen
			drawing();
			gc.setColor(b1.clr);
			gc.fillOval(b1.x, b1.y, b1.size, b1.size); // each one creates the shape of the snow flake
			gc.fillOval(b2.x, b2.y, b2.size, b2.size);
			gc.fillOval(b3.x, b3.y, b3.size, b3.size);
			gc.fillOval(b4.x, b4.y, b4.size, b4.size);
			gc.fillOval(b5.x, b5.y, b5.size, b5.size);
			gc.fillOval(b6.x, b6.y, b6.size, b6.size);
			gc.fillOval(b7.x, b7.y, b7.size, b7.size);
			gc.fillOval(b8.x, b8.y, b8.size, b8.size);
			gc.fillOval(b9.x, b9.y, b9.size, b9.size);
			gc.fillOval(b10.x, b10.y, b10.size, b10.size);
			gc.fillOval(b11.x, b11.y, b11.size, b11.size);
			gc.fillOval(b12.x, b12.y, b12.size, b12.size);
			gc.fillOval(b13.x, b13.y, b13.size, b13.size);
			gc.fillOval(b14.x, b14.y, b14.size, b14.size);
			gc.fillOval(b15.x, b15.y, b15.size, b15.size);
			gc.fillOval(b16.x, b16.y, b16.size, b16.size);
			gc.fillOval(b17.x, b17.y, b17.size, b17.size);
			gc.fillOval(b18.x, b18.y, b18.size, b18.size);
			gc.fillOval(b19.x, b19.y, b19.size, b19.size);
		}
	}
	
	void moveBalls(Snow b) {
		b.y += b.vy; //b1.y = b1.y + by.vy;

		if (b.y >= 560) {
			b.y = 10;
		}
	}
	
	void moveHat(hat b) {
		gc.setColor(h1.hclr);
		gc.setStroke(3);
		gc.drawRect(h1.x, h1.y, h1.size1, h1.size2);
		gc.drawRect(h2.x1, h2.y1, h2.size3, h2.size4);
		b.y += b.vy; //b1.y = b1.y + by.vy;
		b.y1 += b.vy1; //b1.y = b1.y + by.vy;
		
		if (b.y < 150 || b.y1 < 150) {
			b.vy = -b.vy; 
			b.vy1 = -b.vy1;
			h1.hclr = Color.BLUE; // change the hat colour
		}
		if (b.y > 310 - b.size1 || b.y1 > 310 - b.size1) {
			b.vy = -b.vy; 
			b.vy1 = -b.vy1;
			h1.hclr = Color.BLACK;
		}
	}
}









