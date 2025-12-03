package lesson9;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import hsa2.GraphicsConsole;


/* This program illustrates how to use multiple timers. */

/* You have to add "implements ActionListener" here. */
public class Timer2Example implements ActionListener {
	public static void main(String[] args) {
		new Timer2Example();
	}
	
	GraphicsConsole gc = new GraphicsConsole();	
	Rectangle r1 = new Rectangle(190,100,100,50);
	
	Timer timer1 = new Timer(1000, this);
	Timer timer2 = new Timer(100, this);
		
	int time1, time2;
	
	Timer2Example() {
		gc.setLocationRelativeTo(null);
		
		timer1.start();
		timer2.start();
		
		/***** Either uncomment all FOUR lines labeled AA or else uncomment line labeled BB. ******/
				
		//need a while loop so that the program won't exit immediately
		while(true) {													//AA
			Thread.yield();	//let threads (timers) do their work		//AA
			
			//need some way to exit the program. ** This does not work here! 
			//if (time1 >=10) break;
		}																//AA
	
		//gc.sleep(10_000); //exit after 10 seconds						//BB
		
	} //end of program.
	
	void drawGraphics() {
		synchronized(gc) {			
			gc.clear();
			gc.fillRect(r1.x, r1.y, r1.width, r1.height);
			
			gc.drawString("TIME1=" + time1, 50,50);
			gc.drawString("TIME2=" + time2, 50,100);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == timer1) {
			time1++;
			r1.grow(3, 3);	//I've never used this method before!				
		}
		if (ev.getSource() == timer2) {
			time2++;
			
		}
		
		drawGraphics();	//graphics is redrawn each time that either timer is triggered
		
		//need some way to exit the program (using a global boolean would be better)
		if (time1 >=10) System.exit(0);									//AA
	}
}