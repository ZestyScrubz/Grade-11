package keyboardMouse;

import java.awt.Color;
import java.awt.Rectangle;
import hsa2.GraphicsConsole;
public class keyboard1 {

	public static void main(String[] args) {
		new keyboard1();

	}
	
	GraphicsConsole gc = new GraphicsConsole(700,500);
	Rectangle paddle = new Rectangle(300,450,80,10);
	Rectangle r1 = new Rectangle(100,100,50,160);
	
	final static int PADDLEMOVE = 5; //number of pixels that the paddle will move with each key press
	
	boolean trigger = false;
	
	keyboard1() {
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();
		gc.setLocationRelativeTo(null);
		//gc.setTitle("Click on the Green Rectangle");
		
		
		while(true) {
			/********** display keycodes in the TITLE *********/
			// it's a quick and clever way to find them
			gc.setTitle("The keycode for the current key is " + gc.getMousePosition());
			
			
			
			/*****************************************************
			 * Move the paddle using keys
			 * ***************************************************
			 * PROBLEMS:
			 * 1. Notice that the paddle should only move 5 pixels but it moves a LOT more
			 * 2. Operating system delay
			 * 3. No way to move diagonally by holding two keys down at the same time
			 * ***************************************************/
			if (gc.getKeyChar() == 'a') {
				if (paddle.x > 0) paddle.x -= PADDLEMOVE;
			}
			if (gc.getKeyChar() == 'd') {
				if (paddle.x < 690) paddle.x += PADDLEMOVE;  //FIXME: ERROR: DO NOT USE MAGIC NUMBERS
			}
			if (gc.getKeyChar() == 'w') {
				if (paddle.y > 0) paddle.y -= PADDLEMOVE;
			}
			if (gc.getKeyChar() == 's') {
				if (paddle.y < 490) paddle.y += PADDLEMOVE;
			}
			
			
			
			/****************************************************
			 * 1. Problem 1.  FAIL.
			 * 	  NO. THIS DOES NOT SOLVE THE PROBLEM OF MULTIPLE INPUTS WITH ONE PRESS OF A KEY!!!
			 * 
			 * 2. Problem 2.  SUCCESS (but not noticable on my computer)
			 * 
			 * 3. Problem 3: SUCCESS 
			 *******************************************************/
			if (gc.isKeyDown(37)) {	//isKeyDown uses keyCodes. Left arrow
				if (paddle.x > 0) paddle.x -= PADDLEMOVE;
			}
			if (gc.isKeyDown(39)) { //right
				if (paddle.x < 690) paddle.x += PADDLEMOVE;
			}
			if (gc.isKeyDown(38)) {	//up
				if (paddle.y > 0) paddle.y -= PADDLEMOVE;
			}
			if (gc.isKeyDown(40)) {	//down
				if (paddle.y < 490) paddle.y += PADDLEMOVE;
			}

			
			
			
			
			/******************************************************************
			 * How to allow something to be done only once upon a keypress:
			 * 'H' will make the block half the height
			 ******************************************************************/
			if (gc.isKeyDown('H')) {
				if (!trigger) {		//if the trigger is ready
					trigger = true;	//the trigger has already been pulled. It needs to be reset
					r1.height = r1.height /2;
				}
			}
			
			if (! gc.isKeyDown('H')) {	//when you let go of the H key
				trigger = false;	//reset the trigger.				
			}
			
			
			/********** Do all drawing together ***********/
			synchronized(gc) {
				gc.clear();
				gc.setColor(Color.GRAY.darker().darker().darker().darker());
				
				for (int i=0; i< 700; i += 10) {
					gc.drawLine(i, 0, i, 500);
				}
				gc.setColor(Color.GREEN);
				gc.fillRect(r1.x, r1.y, r1.width, r1.height);
				gc.setColor(Color.YELLOW);
				gc.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
				gc.drawString("The gray lines are 10 pixels apart", 20,20);
				gc.drawString("Each keypress should move the paddle " + PADDLEMOVE + " pixels.", 20,40);
			}
			gc.sleep(5);
			
		} //end of while loop
		
	}
}

