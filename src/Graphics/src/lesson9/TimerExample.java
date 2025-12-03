package lesson9;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import hsa2.GraphicsConsole;

/***********************************************************
 This program illustrates how to use a timer.
 It also shows the benefits of using a boolean variable 
 and the correct method of using booleans. 
 Mouse clicking was introduced earlier.
 ************************************************************/

/* You have to add "implements ActionListener" here. */
public class TimerExample implements ActionListener {
	public static void main(String[] args) {
		new TimerExample();

	}

	GraphicsConsole gc = new GraphicsConsole();	
	Rectangle r1 = new Rectangle(100,100,100,50);

	final static int TIMERSPEED = 100; //ms
	final static int MAXTIME = 15; //seconds

	Timer timer = new Timer(TIMERSPEED, this);

	boolean isPaused = false;
	double seconds = 0.0;

	TimerExample() {
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();
		gc.setLocationRelativeTo(null);
		gc.setTitle("Click the mouse to pause");
		gc.setColor(Color.CYAN);
		gc.enableMouse();
		timer.start();

		while(seconds < MAXTIME) {

			if (gc.getMouseClick() > 0) {
				isPaused = !isPaused;
			}

			if (isPaused) {
				gc.setTitle("Game paused");
				if (timer.isRunning()) timer.stop();	//only stop it once, not repeatedly.
			} else {
				gc.setTitle("Click the mouse to pause");
				if (! timer.isRunning() ) timer.start();	//only start it once, not repeatedly
			}

			synchronized(gc) {

				gc.clear();
				if (!isPaused) gc.fillRect(r1.x, r1.y, r1.width, r1.height);

				gc.drawString("TIME=" + seconds, 50,50);				
			}

			gc.sleep(10);
		} //end of while loop

		gc.close();

	} //end of program.


	/* Timer creates an action event every TIMERSPEED milliseconds that runs this method */
	@Override
	public void actionPerformed(ActionEvent ev) {
		seconds += TIMERSPEED/1000.0; //All that is being done here is to add a second (or half a second) to the variable seconds.

		/*other things could go here ... like move enemies, etc. 
		 * Or they could go in the main game loop.
		 * The advantage of doing them here is that they are completely independent of what happens in the main game loop
		 * and how fast the animation is drawn. i.e. the enemies would move at a constant speed, regardless of the framerate.
		 */
	}
}

