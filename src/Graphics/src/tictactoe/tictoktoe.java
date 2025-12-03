package tictactoe;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class tictoktoe {

	public static void main(String[]args) {
		new tictoktoe();

	}

	//Global variables

	//If you use custom colors set them up here
	Color COLOURGRID = new Color(100,120,210);

	static final int SIZE = 7; //this is how big the grid is
	static int winw = 900, winh = 800; //NOT FINAL!!! so that we can resize
	GraphicsConsole gc = new GraphicsConsole(winw, winh);
	int cellW = winw/SIZE;
	int cellH = winh/SIZE;

	int[][] board = new int[SIZE][SIZE];
	static final int XX = 1;
	static final int OO = -1;
	static final int EMPTY = 0;

	boolean turnX = true;
	boolean gameover = true;
	boolean tie = false;

	tictoktoe() {
		setup();


		//main loop

		while(gameover && !tie) {
			if(gc.getMouseClick() > 0) {
				handleClick();
			}

			isTie();

			drawGraphics();
			gc.sleep(100);
		}        
	}

	void setup() {
		gc.setAntiAlias(true);
		gc.setLocationRelativeTo(null);
		gc.setStroke(3);
		gc.setTitle("ticTacToe");
		gc.enableMouse(); //<<<< important for clicking
		gc.setResizable(true);

	}

	void handleClick() {
		//1. pixel to grid
		int mx = gc.getMouseX();
		int my = gc.getMouseY();

		int col = mx/cellW;
		int row = my/cellH;

		//        gc.setTitle("x="+mx + ", col=" + col); //just for testing


		//2. see if the square is empty
		if (board[row][col] != EMPTY) return; //or  == !0
		//3. place the x or O in the square
		if(turnX) board[row][col] = XX;
		else      board[row][col] = OO;


		//4. draw graphics

		//5. did anyone win (use method)
		checkWin();        

		//7. change turn

		turnX = !turnX;

	}

	void drawGraphics() {

		winw = gc.getDrawWidth();
		winh = gc.getDrawHeight();
		cellW = winw/SIZE;
		cellH = winh/SIZE;

		synchronized(gc) {

			gc.clear();

			//1. recalculate screen size

			//draw grid
			gc.setColor(COLOURGRID);
			for(int i = 1; i < SIZE; i++) { 
				gc.drawLine(i*cellW, 0, i*cellW, winh);  
				gc.drawLine(0, i*cellH, winw, i*cellH); 
			} 

			//draw X or O from board
			gc.setColor(Color.RED);
			for(int row = 0; row < SIZE; row++) {
				for(int col = 0; col < SIZE; col++) {
					if(board[row][col] == OO) {
						gc.drawOval(col*cellW, row*cellH, cellW, cellH);
					}

					if(board[row][col] == XX) {
						gc.drawLine(col*cellW,row*cellH,col*cellW+cellW,row*cellH+cellH);
						gc.drawLine(col*cellW,(row+1)*cellH,(col+1)*cellW,row*cellH);
					}
				}
			}
		}   
	}    

	void checkWin() {

		int score = 0;

		//check win horizontally
		for(int r = 0; r < board.length; r++) {

			score = 0;

			for(int c =0; c< board.length; c++) {

				score = score + board[r][c];

				if(score == 4){
					gc.showDialog("X wins!", "");
					gameover = false;
				}
				if(score == -4) {
					gc.showDialog("O wins!","" );
					gameover = false;
				}   
			}
		}

		//Check vertical win
		for(int c = 0; c < board.length; c++) {

			score = 0;

			for(int r = 0; r < board.length; r++) {
				score = score + board[r][c];
				if(score == 4){
					gc.showDialog("X wins!", "");
					gameover = false;
				}
				if(score == -4) {
					gc.showDialog("O wins!","" );
					gameover = false;
				}
			}   
		}

		score = 0;

		//Check diagonal win

		for(int c = 0; c < board.length; c++) {
			score  += board[c][c];
			if(score == 4){
				gc.showDialog("X wins!", "");
				gameover = false;
			}
			if(score == -2) {
				gc.showDialog("O wins!","" );
				gameover = false;
			}
		}

		score = 0;
		

		for(int c = 0; c < board.length; c++) {
			score += board[6-c][c];    

			if(score == 4){
				gc.showDialog("X wins!", "");
			}
			if(score == -4) {
				gc.showDialog("O wins!","" );
			}
		}
	}

	void isTie(){

		tie = false;

		for(int r = 0; r < SIZE; r++) {            
			for(int c = 0; c < SIZE; c++) {
				if(board[r][c] == 0)
					return;
			}
		}
		tie = true;
		gc.showDialog("Tie!", "");
	}
}