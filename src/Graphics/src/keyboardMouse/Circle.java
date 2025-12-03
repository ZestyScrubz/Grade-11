package keyboardMouse;

import java.awt.Color;
import java.awt.Rectangle;
import hsa2.GraphicsConsole;


class Circle extends Rectangle{
	
	Color colour;
	private static final int MAXSPEED = 3;
	int vx,vy; //speeds
	private static Color[] colours = {Color.CYAN, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
	
	Circle(){
		width = height = (int) (30); //Diameters go from 50-250
		
		//make random location (x,y), but not within 100 pixels of border.
		x = (int) (Math.random()*200)+100;
		y = (int) (Math.random()*200)+100;
		
		
		vx = (int) (Math.random()*MAXSPEED+1); //1,2,3 ... MAXSPEED
		vy = (int) (Math.random()*MAXSPEED+1);
		//randomly make speeds + or -
		if (Math.random() < 0.5) vx = -vx;
		if (Math.random() < 0.5) vy = -vy;
		
		colour = colours[(int) (Math.random()*colours.length)];
		
	}
}

