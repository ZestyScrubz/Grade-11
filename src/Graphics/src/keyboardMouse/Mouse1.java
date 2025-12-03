package keyboardMouse;

import java.awt.Color;
import java.awt.Rectangle;

import hsa2.GraphicsConsole;

public class Mouse1 {

	public static void main(String[] args) {
		new Mouse1();
	}
	
	GraphicsConsole gc = new GraphicsConsole();
	Rectangle paddle = new Rectangle(300,300,300,300);
	Rectangle r1 = new Rectangle(100,100,100,50);
	
	Mouse1() {
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();
		gc.setLocationRelativeTo(null);
		gc.setTitle("Click on the Green Rectangle");
		
		//this enables mouse clicking
		gc.enableMouse();
		
		//this line lets the program respond to the motion of the mouse
		gc.enableMouseMotion();
		
		while(true) {
			
			//This line makes the paddle move with the x location of the mouse. 
			//TODO: You'll have to fix it to get the mouse in the middle of the paddle though.
			paddle.x = gc.getMouseX();
			paddle.y = gc.getMouseY();	//you probably don't want to do this. 
			
			if (gc.getMouseClick() > 0) {	
				if (r1.contains(gc.getMouseX(), gc.getMouseY())) {
					r1.x +=50;
					r1.y +=50;
				}
			}
			synchronized(gc) {
				gc.clear();
				
				gc.setColor(Color.GREEN);
				gc.fillRect(r1.x, r1.y, r1.width, r1.height);
				gc.setColor(Color.YELLOW);
				gc.fillOval(paddle.x, paddle.y, paddle.width, paddle.height);
			}
			gc.sleep(5);
			
		} //end of while loop
		
	}
}

