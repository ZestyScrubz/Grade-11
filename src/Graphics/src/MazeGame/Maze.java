package MazeGame;

import java.awt.Color;
import java.awt.Rectangle;

import hsa2.GraphicsConsole;

public class Maze {

	public static void main(String[] args) {
		new Maze();
	}
	static int WINW = 800, WINH = 800;
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	Rectangle ball = new Rectangle(300,450,60,60);
	int sleepTime = 1; //controls speed of animation. Normally 1-10
	final static int BALLMOVE = 5;

	Maze(){
		setup();

		while(true) {
			moveBall();
			gc.sleep(sleepTime);
		}
	}

	void setup() {
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null); //centre the window
	}

	void moveBall(){
		synchronized(gc) {
			
			gc.clear();
			
			gc.drawOval(ball.x, ball.y, ball.width, ball.height);
			if (gc.getKeyChar() == 'a') {
				if (ball.x > 0) ball.x -= BALLMOVE;
			}
			if (gc.getKeyChar() == 'd') {
				if (ball.x < 690) ball.x += BALLMOVE;  //FIXME: ERROR: DO NOT USE MAGIC NUMBERS
			}
			if (gc.getKeyChar() == 'w') {
				if (ball.y > 0) ball.y -= BALLMOVE;
			}
			if (gc.getKeyChar() == 's') {
				if (ball.y < 490) ball.y += BALLMOVE;
			}

			gc.sleep(5);
		}
	}
}
