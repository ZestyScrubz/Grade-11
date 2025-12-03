package Culminating;
/*
 * Isaac Tran
 * 2023-01-18
 * A Simple Connect Four program
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import hsa2.GraphicsConsole;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConnectFour /*implements ActionListener*/ {

	public static void main(String[] args) {
		new ConnectFour();
	}

	static final int gridC = 8; // number of columns
	static final int gridR = 8; // number of rows
	static final int EMPTY = 0;
	static final int P1 = 1;
	static final int P2 = -1;
	static final int TIMERSPEED = 1000;
	int time1 = 8, time2 = 8;

	//Timer timer = new Timer(TIMERSPEED, this);

	boolean tie = false;
	boolean gameover = true;

	//NOT constants
	int winW = 700;
	int winH = 600;
	int boxW, boxH;
	GraphicsConsole gc = new GraphicsConsole(winW, winH);
	GraphicsConsole intro = new GraphicsConsole(winW, winH);
	int[][] board = new int[gridC][gridR];
	boolean turn1 = true;

	Color color1 = Color.BLUE;
	Font fontMain = new Font("Arial", Font.PLAIN, 24);

	ConnectFour() {
		introSetup();
		setup();

		//timer.start();

		gc.setVisible(false);
		intro.setVisible(true);

		introButton();

		gc.setVisible(true);
		intro.setVisible(false);

		// game loop
		while(gameover && !tie) { //FIXME we need to be able to win/lose
			if(gc.getMouseClick() > 0) {
				handleClick();
			}

			isTie();

			drawGraphics();
			gc.sleep(10);
		}

	}


	void setup() {
		gc.setTitle("TicTacToe");
		gc.setAntiAlias(true);
		gc.setStroke(2);
		gc.setLocationRelativeTo(null);
		gc.enableMouse(); //For clicking
		gc.setResizable(true); 	
	}
	void introSetup() {
		intro.setTitle("TicTacToe");
		intro.setAntiAlias(true);
		intro.setStroke(2);
		intro.setLocationRelativeTo(null);
		intro.enableMouse(); //For clicking
		intro.setResizable(true); 	


	}
	void introButton() {
		color1 = Color.BLACK;

		Rectangle btn = new Rectangle(300, 380, 80, 50);
		intro.setColor(color1);
		intro.fillRect(btn.x, btn.y, btn.width, btn.height);
		intro.setColor(Color.WHITE);
		intro.drawString("START", 321, 410);
		intro.setColor(Color.BLACK);
		intro.setFont(fontMain);
		intro.drawString("Each player will have their turn placing pieces.", 100, 100);
		intro.drawString("You will have 8 seconds to play a piece.", 125, 150);
		intro.drawString("You will recieve an 'anvil' piece at random which will destroy", 35, 200);
		intro.drawString("a whole row.", 270, 250);
		intro.drawString("Just click on the column you want to play your piece!", 75, 300);
		intro.drawString("First to get Four in a row wins!", 190, 350);



		//This will loop until the button is clicked or "ESC" is pressed
		while (true) {
			if (intro.getMouseClick() > 0) {	//if someone clicks the mouse		
				if (btn.contains(intro.getMousePosition())) { //get the mouse position and see if it is inside the button
					return;
				}
			}

			if (intro.getKeyCode() == 27) return;	 //the ESC button was pressed
			intro.sleep(10); //if you didn't click the button, sleep and then check again.

		}
	}


	void handleClick() {
		int mx = gc.getMouseX();
		int my = gc.getMouseY();

		int col = mx/boxW;
		int row = my/boxH;
		row = stack(col);

		// 2. put Red or Blue in board
		if(turn1) {
			board[row][col] = P1;
		}
		else board[row][col] = P2; 
		// 3. Did player win?
		checkWin();
		// 5. Change Turn
		turn1 = !turn1;
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
		synchronized(gc) {


			// draw grid
			gc.clear();

			/*			gc.setColor(Color.BLACK);
			gc.setFont(fontMain);
			gc.drawString("TIME1=" + time1, 100,100);
			gc.drawString("TIME2=" + time2, 100,200);
			 */	
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
						gc.fillOval(col*boxW, row*boxH, boxW, boxH);
					}
					if (board[row][col] == P2) {
						gc.setColor(Color.BLUE);
						gc.fillOval(col*boxW, row*boxH, boxW, boxH);
					}
				}
			}
		}
	}
	void checkWin() {
		// vertical Check 
		for (int r = 0; r < gridR-3; r++ ){
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
		for (int c = 0; c < gridC-3; c++) {
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

		// up right and down left diagonals
		for (int c = 0; c < gridC-3; c++) {
			for (int r = 0; r < gridR; r++) {
				if (board[r][c] == P1 && board[r-1][c+1] == P1 && board[r-2][c+2] == P1 && board[r-3][c+3] == P1) { // check one piece, go left and down, check if piece is the same, and so on
					gc.showDialog("Player 1 wins!", " ");
					gameover = false;
				} else if (board[r][c] == P2 && board[r-1][c+1] == P2 && board[r-2][c+2] == P2 && board[r-3][c+3] == P2) { // check one piece, go left and down, check if piece is the same, and so on
					gc.showDialog("Player 2 wins!", " ");
					gameover = false;
				} 
			}
		}

		// up left and down right diagonals
		for (int c = 0; c < gridC-8; c++) {
			for (int r = 0; r < gridR; r++) {
				if (board[r][c] == P1 && board[r-1][c-1] == P1 && board[r-2][c-2] == P1 && board[r-3][c-3] == P1) { // check one piece, go left and up, check if piece is the same, and so on
					gc.showDialog("Player 1 wins!", " ");
					gameover = false;
				} else if (board[r][c] == P2 && board[r-1][c-1] == P2 && board[r-2][c-2] == P2 && board[r-3][c-3] == P2) { // check one piece, go left and up, check if piece is the same, and so on
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
				if(board[r][c] == 0)
					return;
			}
		}
		tie = true;
		gc.showDialog("Tie!", "");
	}

	/*	public void actionPerformed(ActionEvent ev) {
		if (turn1 && ev.getSource() == timer) {
			time2 = 6;
			time1--;			
		}
		if(!turn1 && ev.getSource() == timer) {
			time1 = 6;
			time2--;
		}

		drawGraphics();	//graphics is redrawn each time that either timer is triggered

		//need some way to exit the program (using a global boolean would be better)
		if (time1 <= 0 || time2 <= 0) turn1 = !turn1;	
	}
	 */
}