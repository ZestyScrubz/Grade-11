package keyboardMouse;


import java.awt.Color;
import java.awt.Rectangle;

import hsa2.GraphicsConsole;

public class Mouse2 {

	public static void main(String[] args) {
		new Mouse2();

	}

	/* Global Variables */
	GraphicsConsole gc = new GraphicsConsole();
	Rectangle r1 = new Rectangle(100,100,400,200);
	int mouseX, mouseY;
	Color rectColor = Color.RED;

	Mouse2() {
		setup();

		//Animation Loop
		while (true) {
			//Get current mouse location
			mouseX = gc.getMouseX();
			mouseY = gc.getMouseY();

			/*****************************************************************************
			 * Check to see if the mouse cursor is located within the Rectangle r1.
			 * If so, we will change the color. If we left click on the rectangle, we decrease
			 * the width. If we right click, we increase the height.
			 * 
			 * When we move the mouse away from the Rectangle, the color changes and our
			 * mouse clicks do nothing.
			 */
			if (r1.contains(mouseX, mouseY)) {	//check the intersection

				rectColor = Color.green;

				//Change dimensions if we click on the rectangle
				if (gc.getMouseButton(0) && gc.getMouseClick() > 0) {	//left click
					r1.width -= 20;
				} else if (gc.getMouseButton(2) && gc.getMouseClick() > 0) {	//right click
					r1.height += 10;
				}
			} else {
				rectColor = Color.red; //reset's the rectangle's color
			}

			drawGraphics();
		}//end while

	}

	void setup() {
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();
		gc.setLocationRelativeTo(null);
		gc.setTitle("Mouse Intersecting Rectangle");
		gc.enableMouseMotion();
		gc.enableMouse();
		gc.getMouseClick();
	}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear();

			gc.setColor(rectColor);
			gc.fillRect(r1.x, r1.y, r1.width, r1.height);
		}
		gc.sleep(5);
	}

}
