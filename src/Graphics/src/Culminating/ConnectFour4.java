package Culminating;
/*
 * Isaac Tran
 * 2023-01-18
 * A Simple Connect Four program
 */
import java.awt.*;

import java.util.*;

import hsa2.GraphicsConsole;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConnectFour4 implements ActionListener {

	public static void main(String[] args) {
		new ConnectFour4();
	}

	Piece p1, p2;

	static final int gridC = 8; // number of columns
	static final int gridR = 8; // number of rows
	static final int EMPTY = 0;
	static final int P1 = 1;
	static final int P2 = -1;
	static final int TIMERSPEED = 1000;
	int time1 = 8, time2 = 8;

	Timer timer = new Timer(TIMERSPEED, this);

	boolean tie = false;
	boolean gameover = true;
	boolean smash = false;

	//NOT constants
	int winW = 700;
	int winH = 600;
	int boxW, boxH;
	GraphicsConsole gc = new GraphicsConsole(winW, winH);
	GraphicsConsole intro = new GraphicsConsole(winW, winH);
	GraphicsConsole info = new GraphicsConsole(winW, winH);
	int[][] board = new int[gridC][gridR];
	boolean turn1 = true;

	Color color1 = Color.BLUE;
	Font fontMain = new Font("Comic Sans", Font.PLAIN, 24);
	Font fontTime = new Font("Arial", Font.PLAIN, 100);

	ConnectFour4() {
		introSetup();
		infoSetup();
		setup();

		gc.setVisible(false);
		info.setVisible(false);
		intro.setVisible(true);

		introButton();


		// game loop
		while(gameover && !tie) { 
			if(gc.getMouseClick() > 0) {
				handleClick();
			}

			isTie();

			drawGraphics();
			gc.sleep(10);
		}

	}


	void setup() {
		gc.setTitle("Connect Four");
		gc.setAntiAlias(true);
		gc.setStroke(2);
		gc.setLocationRelativeTo(null);
		gc.enableMouse(); //For clicking
		gc.setResizable(true); 	
		p1 = new Piece();
		p2 = new Piece();
	}
	void introSetup() {
		intro.setTitle("Connect Four");
		intro.setAntiAlias(true);
		intro.setStroke(2);
		intro.setLocationRelativeTo(null);
		intro.enableMouse(); //For clicking
		intro.setResizable(true); 	
	}
	void infoSetup() {
		info.setTitle("Connect Four");
		info.setAntiAlias(true);
		info.setStroke(2);
		info.setLocationRelativeTo(null);
		info.enableMouse(); //For clicking
		info.setResizable(true); 	
	}
	void introButton() {
		color1 = Color.BLACK;

		Rectangle btn = new Rectangle(300, 480, 80, 50);
		Rectangle btn2 = new Rectangle(620, 550, 80, 50);
		intro.setColor(color1);
		intro.fillRect(btn.x, btn.y, btn.width, btn.height);
		intro.setColor(Color.RED);
		intro.fillRect(btn2.x, btn2.y, btn2.width, btn2.height);
		intro.setColor(Color.WHITE);
		intro.drawString("START", 321, 510);
		intro.drawString("ANVIL INFO", 631, 580);
		intro.setColor(Color.BLACK);
		intro.setFont(fontMain);
		intro.drawString("Each player will have their turn placing pieces.", 100, 100);
		intro.drawString("You will have 8 seconds to play a piece.", 125, 150);
		intro.drawString("You might recieve an 'anvil' piece at random which will destroy", 35, 200);
		intro.drawString("a whole column.", 265, 250);
		intro.drawString("But be carful. If you run out of time, ", 150, 300);
		intro.drawString("the other player will revice the anvil!", 150, 350);
		intro.drawString("Just click on the column you want to play your piece!", 75, 400);
		intro.drawString("First to get Four in a row wins!", 190, 450);



		//This will loop until the button is clicked or "ESC" is pressed
		while (true) {
			if (intro.getMouseClick() > 0) {	//if someone clicks the mouse		
				if (btn.contains(intro.getMousePosition())) { //get the mouse position and see if it is inside the button
					timer.start();
					gc.setVisible(true);
					intro.setVisible(false);
					info.setVisible(false);
					return;
				} else if (btn2.contains(intro.getMousePosition())) { //get the mouse position and see if it is inside the button
					gc.setVisible(false);
					intro.setVisible(false);
					info.setVisible(true);
					infoButton();
					return;
				}
			}

			if (intro.getKeyCode() == 27) return;	 //the ESC button was pressed
			intro.sleep(10); //if you didn't click the button, sleep and then check again.
		}
	}
	void infoButton() {
		color1 = Color.BLACK;

		Rectangle btn = new Rectangle(300, 480, 80, 50);
		info.setColor(color1);
		info.fillRect(btn.x, btn.y, btn.width, btn.height);
		info.setColor(Color.WHITE);
		info.drawString("START", 321, 510);
		info.setColor(Color.BLACK);
		info.setFont(fontMain);
		info.drawString("The anvil is given to a player at a random time.", 100, 100);
		info.drawString("Place their piece and it will destroy all piece under it.", 95, 150);
		info.drawString("It doesn't matter what colour piece it is", 150, 200);
		info.drawString("You might not get the piece,", 200, 250);
		info.drawString("Or you might get it multiple times", 160, 300);
		info.drawString("Be stratigic When playing this piece", 150, 350);



		//This will loop until the button is clicked or "ESC" is pressed
		while (true) {
			if (info.getMouseClick() > 0) {	//if someone clicks the mouse		
				if (btn.contains(info.getMousePosition())) { //get the mouse position and see if it is inside the button
					timer.start();
					gc.setVisible(true);
					intro.setVisible(false);
					info.setVisible(false);
					return;
				}
			}

			if (info.getKeyCode() == 27) return;	 //the ESC button was pressed
			info.sleep(10); //if you didn't click the button, sleep and then check again.

		}
	}

	void handleClick() {
		// 1. get mouse location so we know where the user presses
		int mx = gc.getMouseX();
		int my = gc.getMouseY();

		int col = mx/boxW;
		int row = my/boxH;
		row = stack(col);

		// 2. put Red or Blue in board
		if(turn1 && !smash) {
			board[row][col] = P1;
		} if(turn1 && smash) {
			gc.setFont(fontMain);
			gc.drawString("Player 2 has anvil", 200, 300);
			for (int r = 0; r < gridR; r++) { // change every row to empty
				board[r][col] = EMPTY;
				smash = false;
			}
		} 
		else if (!turn1 && !smash) {
			board[row][col] = P2; 
		} else if (!turn1 && smash) {
			for (int r = 0; r < gridR; r++) { // change every row to empty
				board[r][col] = EMPTY;
				smash = false;
			}
		}

		// 2. Did player win?
		checkWin();
		// 4. Change Turn
		turn1 = !turn1;
		// 5. run anvil piece
		anvil();


	}

	int stack(int col){
		int row = gridR-1; // will take us to the bottom row
		while(board[row][col] != EMPTY || row < 0) { // if there is an empty spot or if column is not full
			row--; // look at the next spot
			checkWin();

		}
		return row;
	}

	void drawGraphics() {
		//recalc in case screen has been resized
		winW = gc.getDrawWidth();
		winH = gc.getDrawHeight();

		boxW = winW/gridC;
		boxH = winH/gridR;

		p1.w = boxW;
		p1.h = boxH;
		p2.w = p1.w;
		p2.h = p1.h;
		synchronized(gc) {


			// draw grid
			gc.clear();

			gc.setColor(Color.BLACK);
			countDown();
			gc.setColor(new Color(50,30,60, 250));
			for(int i = 0; i <= gridC; i++) {
				gc.drawLine(i*boxW, 0, i*boxW, winH);
				gc.drawLine(0, i*boxH, winW, i*boxH);
			}

			// draw Red or Blue
			for(int row = 0; row < gridR; row++) {
				for(int col = 0; col < gridC; col++) {
					if(board[row][col] == P1) {
						gc.setColor(Color.RED);
						gc.fillOval(col*p1.w, row*p1.h, p1.w, p1.h); // print the colour the same size of the board
					}
					if (board[row][col] == P2) {
						gc.setColor(Color.BLUE);
						gc.fillOval(col*p2.w, row*p2.h, p2.w, p2.h);
					}
				}
			}
		}
	}
	void anvil() {
		Random r = new Random();
		int[] anvil = new int[2];
		anvil[1] = r.nextInt(13) + 1;	  
		System.out.println(anvil[1]);
		if (anvil[1] > 12) {
			System.out.println("You have anvil");
			smash = true;
		}

	}
	void checkWin() {

		// vertical Check 
		for (int r = 0; r < gridR-3; r++ ){ // you can't make four in a row with the top 3 row so we skip
			for (int c = 0; c < gridC; c++){
				if (board[r][c] == P1 && board[r+1][c] == P1 && board[r+2][c] == P1 && board[r+3][c] == P1){ // check if 4 pieces in columns are player 1
					gc.showDialog("Player 1 wins!", " ");
					gameover = false;
				} else if (board[r][c] == P2 && board[r+1][c] == P2 && board[r+2][c] == P2 && board[r+3][c] == P2) { //same but player 2
					gc.showDialog("Player 2 wins!", " ");
					gameover = false;   
				}
			}
		}
		// horizontal Check
		for (int c = 0 ; c < gridC-3; c++) { // you can't make four in the row with the 3 end columns so we skip
			for (int r = 0; r < gridR; r++) {
				if (board[r][c] == P1 && board[r][c+1] == P1 && board[r][c+2] == P1 && board[r][c+3] == P1) { // check row if 4 pieces are next to each other are player 1
					gc.showDialog("Player 1 wins!", " ");
					gameover = false;
				} else if (board[r][c] == P2 && board[r][c+1] == P2 && board[r][c+2] == P2 && board[r][c+3] == P2) { // same but player 2
					gc.showDialog("Player 2 wins!", " ");
					gameover = false;
				}
			}
		}
		// diagonals not working well
		// up right and down left diagonals
		for (int r = 3; r < gridR; r++){
			for (int c = 0; c < gridC-3; c++){
				if (board[r][c] == P1 && board[r-1][c+1] == P1 && board[r-2][c+2] == P1 && board[r-3][c+3] == P1) {
					gc.showDialog("Player 1 wins!", " ");
					gameover = false;
				} else if (board[r][c] == P2 && board[r-1][c+1] == P2 && board[r-2][c+2] == P2 && board[r-3][c+3] == P2) {
					gc.showDialog("Player 2 wins!", " ");
					gameover = false;
				}
			}
		}
		// up left and down right diagonal
		for (int r = 3; r < gridR; r++){
			for (int c = 3; c < gridC; c++){
				if (board[r][c] == P1 && board[r-1][c-1] == P1 && board[r-2][c-2] == P1 && board[r-3][c-3] == P1) {
					gc.showDialog("Player 1 wins!", " ");
					gameover = false;
				} else if (board[r][c] == P2 && board[r-1][c-1] == P2 && board[r-2][c-2] == P2 && board[r-3][c-3] == P2) {
					gc.showDialog("Player 2 wins!", " ");
					gameover = false;
				}
			}
		}
	}

	void isTie(){

		tie = false;

		for(int r = 0; r < gridC; r++) {            
			for(int c = 0; c < gridR; c++) {
				if(board[r][c] == 0) // if the whole board it filled it is a tie
					return;
			}
		}
		tie = true;
		gc.showDialog("Tie!", "");
	}
	void countDown() {
		int timerX = 315, timerY = 300;
		if (time2 == 8) {
			gc.setFont(fontMain);
			gc.drawString("Player 1's turn (Red)", timerX - 90, timerY - 180);
		}
		if (time1 == 3) {
			gc.setFont(fontTime);
			gc.drawString("" + time1, timerX+10, timerY);
		}
		if (time1 == 2) {
			gc.setFont(fontTime);
			gc.drawString("" + time1, timerX+10, timerY);
		}

		if (time1 == 1) {
			gc.setFont(fontTime);
			gc.drawString("" + time1, timerX, timerY);
		}

		if (time1 == 8) {
			gc.setFont(fontMain);
			gc.drawString("Player 2's turn (Blue)", timerX - 90, timerY - 180);
		}
		if (time2 == 3) {
			gc.setFont(fontTime);
			gc.drawString("" + time2, timerX+10, timerY);
		}
		if (time2 == 2) {
			gc.setFont(fontTime);
			gc.drawString("" + time2, timerX+10, timerY);
		}
		if (time2 == 1) {
			gc.setFont(fontTime);
			gc.drawString("" + time2, timerX, timerY);
		} 
	}
	public void actionPerformed(ActionEvent ev) {
		if (turn1 && ev.getSource() == timer) {
			time2 = 8;
			time1--;			
		}
		if(!turn1 && ev.getSource() == timer) {
			time1 = 8;
			time2--;
		}

		drawGraphics();	//graphics is redrawn each time that either timer is triggered

		//need some way to exit the program (using a global boolean would be better)
		if (time1 <= 0 || time2 <= 0) turn1 = !turn1;	
	}

}