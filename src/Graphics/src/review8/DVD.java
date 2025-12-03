package review8;
import java.awt.Color;
import hsa2.GraphicsConsole;
import java.awt.Font;

public class DVD {

	static int SPEED = 3;
	int x, y, size;
	int vx, vy;

	DVD(){
		size = 50;
		
		x = (int)(Math.random() * BouncingDVD.WINH-200)+100;
		y = (int)(Math.random() * BouncingDVD.WINH-200)+100;
		
		vx = vy = SPEED;
		//randomly make speeds + or -
		if (Math.random() < 0.5) vx = -vx;
		if (Math.random() < 0.5) vy = -vy;
	}
	void increaseSize() {
		this.size += 10; 
	}
	void decreaseSize() {
		this.size -= 10; 
	}

}