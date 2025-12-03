package lesson9;
import java.awt.Color;
import java.awt.Font;
import hsa2.GraphicsConsole;
import java.util.Random;
import java.awt.Rectangle;


public class AwesomeGame {

	public static void main(String[] args) {
		new AwesomeGame();
	}
	
	/* Constants and global variables */
	static final Color NAVY = new Color(50, 50, 140);
	static final int WINW = 600;
	static final int WINH = 600;
	Font fontMain = new Font("Arial", Font.PLAIN, 24);
	Random rand = new Random();
	
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
	
	GraphicsConsole gcIntro = new GraphicsConsole(500,400);
	
	boolean gameOver = false;
	
	AwesomeGame(){
		/*** setup each window ***/
		introSetup();
		setup();
		
		
		/*** display only intro window ***/
		gc.setVisible(false);
		gcIntro.setVisible(true);
		
		/*** now we need to wait on the intro screen until someone clicks the button or presses ESC ***/
		introButtonClick();
		
		/*** hide the instro screen and show the main window ***/
		gc.setVisible(true);
		gcIntro.setVisible(false);
		
		/*** main game loop for gc window ***/
		while(! gameOver) {
			
			drawGraphics();
			gc.sleep(30);
			
		}
		
		//the game is now over
		gc.showDialog("Thanks for playing",  "Game Over");
	}
	

	/*************************************************************** 
   	 * This method sets up everything for the introductory window.
	 ***************************************************************/	 
	void introSetup() {
		gcIntro.setTitle("My Awesome program: Instructions");
		gcIntro.setAntiAlias(true);
		gcIntro.enableMouse();
		gcIntro.setBackgroundColor(Color.WHITE);
		gcIntro.clear();		
		gcIntro.setFont(fontMain);
		gcIntro.setStroke(3);
		gcIntro.setLocationRelativeTo(null);
		
		/*Now write all of the instructions on the window */
		gcIntro.setColor(Color.YELLOW);
		gcIntro.fillRect(35,55,440,40);
		gcIntro.setColor(Color.BLACK);
		gcIntro.drawString("Welcome to the Game of Awesomeness", 40,80);
		gcIntro.setColor(Color.RED);
		gcIntro.drawString("In this game you will ....", 40,120);
					
	}
	
	/*************************************************************************** 
   	 * This method makes a button and waits here in a loop until it is clicked
	 ***************************************************************************/	 
	void introButtonClick() {
		/* Make the button. 
		 * NOTE: It should be a local variable since it is not needed anywhere else */		
		Rectangle btn = new Rectangle(40,300,80,50);
		gcIntro.setColor(Color.GRAY);
		gcIntro.drawRect(btn.x+3, btn.y+3, btn.width, btn.height);
		gcIntro.setColor(NAVY);
		gcIntro.drawRect(btn.x, btn.y, btn.width, btn.height);
		gcIntro.drawString("Go",62,332);
		
		//This will loop until the button is clicked or "ESC" is pressed
		while (true) {
			if (gcIntro.getMouseClick()>0) {	//if someone clicks the mouse				
				if (btn.contains(gcIntro.getMousePosition())) { //get the mouse position and see if it is inside the button
					return;
				}
			} 
			
			if (gcIntro.getKeyCode() == 27) return;	 //the ESC button was pressed
			
			gcIntro.sleep(100); //if you didn't click the button, sleep and then check again.
			
		}
	}
	
	/**************************************
	 * Methods for gc                     *
	 * ************************************/
	void setup() {
		gc.setTitle("My Awesome program: The Game");
		gc.setAntiAlias(true);
		gc.enableMouse();
		gc.enableMouseMotion();
		gc.setBackgroundColor(Color.BLACK);		
		gc.clear();		
		gc.setFont(fontMain);		
		gc.setLocationRelativeTo(null);
	}
	
	void drawGraphics() {
		synchronized (gc) {
			int n = 100;
			gc.setColor(Color.YELLOW);
			if (Math.random() < 0.2) {
				n *= 2;
				gc.setColor(Color.WHITE);
			}
			gc.drawLine(WINW/2, WINH/2, WINW/2+ rand.nextInt(2*n)-n, WINH/2+rand.nextInt(2*n)-n);
			gc.drawString("Something Awesome goes here", 100,160);
		}
	}
}
