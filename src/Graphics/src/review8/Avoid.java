package review8;
import java.util.*;
import java.awt.Color;
import java.awt.Rectangle;
import hsa2.GraphicsConsole;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;



public class Avoid implements ActionListener {

	public static void main(String[] args) {
		new Avoid();
	}
	static int WINW = 900;
	static int WINH = 600;
	static int SLEEPTIME = 5;
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	Rectangle paddle = new Rectangle(300,550,130,15);
	ArrayList<ball> Ball = new ArrayList<ball>();

	int TIMERSPEED = 200;
	double time = 0.0;
	Timer timer = new Timer (TIMERSPEED, this);

	BufferedImage asteroid, spaceship;

	Avoid(){
		setup();
		gc.enableMouseMotion();
		timer.start();

		while(true) {

			paddle.x = gc.getMouseX(); // move paddle

			// move ball
			for (ball a : Ball) moveBall(a);

			//Check for collisions
			if (checkCollision()) System.out.println("hello");	//game over if collision occurs


			drawGraphics();
			gc.sleep(SLEEPTIME);


		}
	}

	/**
	 * Move each asteroid down the screen. If the asteroid reaches the bottom of the screen, move it off screen
	 * @param a	the Asteroid to move
	 */
	void moveBall(ball a) {
		if (a.y > WINH) {
			a.x = 2000;
			a.y = 2000; 
		}
		else a.y += a.speed;

	}
	/**
	 * Check to see if an asteroid has collided with the paddle
	 * @return	Returns true if a collision has occurred, false otherwise
	 */
	boolean checkCollision() {
		for (ball a : Ball) {
			if (paddle.intersects(a)) {
				gc.showDialog("You have collided with an asteroid - Game Over.", "GAME OVER");
				return true;
			}
		}
		return false;
	}


	void setup() {
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null); //centre the window
		gc.setBackgroundColor(Color.BLACK);
		gc.setColor(Color.YELLOW);

		Ball.add(new ball());
		gc.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);

		//load images
		try {
			asteroid = ImageIO.read(new File ("asteroid.jpeg"));
			spaceship = ImageIO.read(new File ("spaceship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void drawGraphics() {
		synchronized(gc) {
			gc.clear();

			//this is a for-each loop. The for-loop version is in moveCircles()
			for (ball a : Ball) {
				gc.setColor(a.colour);
				gc.fillOval(a.x, a.y, a.width, a.height);
				gc.drawImage(asteroid, a.x, a.y, a.width, a.height);

			}		
			gc.drawImage(spaceship, paddle.x, paddle.y, paddle.width, paddle.height);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time++;
		if (time % 3 == 0) Ball.add(new ball());
	}

	static BufferedImage loadImage(String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileName).getAbsoluteFile());
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "An image failed to load", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return img;
	}


}
