package review8;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class ball extends Rectangle {
	int x, y;
	int speed;
	int size;
	Color colour;
	static final int MAXSPEED = 10;
	Random r = new Random();
	
	ball(){
		size = width = height = 40;
		x = r.nextInt(Avoid.WINW);
		y = 0;
		colour = Color.WHITE;
		speed = r.nextInt(MAXSPEED) + 1;
	}
}
