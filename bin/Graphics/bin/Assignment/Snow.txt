package Assignment;


import java.awt.Color;

public class Snow {
	int x, y;
	int vx = 5;
	int vy = 5;
	int size = 10;
	Color clr = Color.WHITE;

	
	Snow(int w){
		w -= 100;
		x = (int)(Math.random()*w) + 100;
		y = (int)(Math.random()*600) + 1;
	}
}

