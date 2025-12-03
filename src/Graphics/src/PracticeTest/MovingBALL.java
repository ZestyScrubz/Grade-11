package PracticeTest;

import java.awt.Color;

public class MovingBALL {
	int x, y;
	int vx = 2;	
	int vy = 2;
	int size = 40;
	Color clr = Color.RED;
	
	MovingBALL(int w){
		w -= 100;
		x = (int)(Math.random()*w) + 50;
		y = (int)(Math.random()*100) + 1;
	}
}
