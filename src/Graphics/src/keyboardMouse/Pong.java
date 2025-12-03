package keyboardMouse;

import java.awt.*;

import hsa2.GraphicsConsole;
public class Pong {
	int winW = 700, winH = 500;
	public static void main(String[] args) {
		new Pong();

	}
	GraphicsConsole gc = new GraphicsConsole(winW,winH);
	GraphicsConsole intro = new GraphicsConsole(winW,winH);
	Rectangle paddle2 = new Rectangle(600,250,10,80);
	Rectangle paddle1 = new Rectangle(100,250,10,80);
	Circle c1 = new Circle();

	final static int PADDLEMOVE = 5; //number of pixels that the paddle will move with each key press

	boolean trigger = false;

	Pong() {
		setup();
		introSetup();
		
		gc.setVisible(false);
		intro.setVisible(true);
		
		
		introButtonClick();
		
		gc.setVisible(true);
		intro.setVisible(false);
		
		
		while(true) {
			if (!checkOutOfBounds(c1)) {
				break;
			}
			moveBall(c1);
			drawGraphics();
			gc.setTitle("The keycode for the current key is " + gc.getKeyCode());
			
			movePaddle();

			gc.sleep(5);

		} //end of while loop
		
	}
	
	boolean checkOutOfBounds (Circle c) {
		if (c.x < 0 && c.vx < 0 || c.x > 670) return false;
		else {
			return true;
		}
	}
	void movePaddle() {
		// right paddle
		if (gc.getKeyChar() == 'w') {
			if (paddle1.y > 0) paddle1.y -= PADDLEMOVE;
		}
		if (gc.getKeyChar() == 's') {
			if (paddle1.y < 420) paddle1.y += PADDLEMOVE;
		}

		//left paddle
		if (gc.isKeyDown(38)) {	//up
			if (paddle2.y > 0) paddle2.y -= PADDLEMOVE;
		}
		if (gc.isKeyDown(40)) {	//down
			if (paddle2.y < 420) paddle2.y += PADDLEMOVE;
		}
	}
	void moveBall(Circle c) {

		c.x += c.vx; 
		c.y += c.vy;
		
		//bounce off walls. We need to add a speed check to prevent circles from getting stuck on edges
		if (c.y < 0 && c.vy < 0) c.vy *= -1;
		if (c.y + c.height > winH && c.vy > 0) c.vy *= -1;
		
		if (paddle1.contains(c.x, c.y)) {
			c.vx *= -1;
		} 
		if (paddle2.contains(c.x + 30, c.y)) {
			c.vx *= -1;
		} 
	}
	void drawGraphics() {
		synchronized(gc) {
			gc.clear();
			gc.setColor(c1.colour);
			gc.fillOval(c1.x, c1.y, c1.width, c1.height);
			gc.setColor(Color.GRAY.darker().darker().darker().darker());
			gc.setColor(Color.GREEN);
			gc.setColor(Color.YELLOW);
			gc.fillRect(paddle1.x, paddle1.y, paddle1.width, paddle1.height);
			gc.fillRect(paddle2.x, paddle2.y, paddle2.width, paddle2.height);

		}	
	}
	void setup(){
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();
		gc.setLocationRelativeTo(null);
	}
	void introSetup() {
		intro.setBackgroundColor(Color.BLACK);
		intro.clear();
		intro.setLocationRelativeTo(null);
		intro.setColor(Color.WHITE);
		intro.setFont(new Font("Times New Roman", Font.BOLD, 30));
		intro.drawString("Welcome to the game of PONG", 150, 100);
		intro.drawString("You know how the game is played...", 130, 150);
		
		
	}
	void introButtonClick() {
		Rectangle btn = new Rectangle(280,300,80,50);
		intro.setColor(Color.GRAY);
		intro.drawRect(btn.x+3, btn.y+3, btn.width, btn.height);
		intro.setColor(Color.BLUE);
		intro.drawRect(btn.x, btn.y, btn.width, btn.height);
		intro.drawString("Go",300,332);
		
		//This will loop until the button is clicked or "ESC" is pressed
		while (true) {
			if (intro.getMouseClick()>0) {	//if someone clicks the mouse				
				if (btn.contains(intro.getMousePosition())) { //get the mouse position and see if it is inside the button
					return;
				}
			} 
			
			if (intro.getKeyCode() == 27) return;	 //the ESC button was pressed
			
			intro.sleep(100); //if you didn't click the button, sleep and then check again.
			
		}
	}

}
