package tictactoe;
import java.awt.Color;
import hsa2.GraphicsConsole;

/*TicTacToe Program
 * Ethan Tran 
 * March 30 2022
 */

public class TicTacToe {

	public static void main(String[] args) {
		new TicTacToe();

	}

	static final int SIZE = 3; //size of grid
	static final int EMPTY = 0;
	static final int XX = 1;
	static final int OO = -1;
	int counter = 0;

	//NOT constants
	int winw = 900;
	int winh = 800;
	int boxW, boxH;
	GraphicsConsole gc = new GraphicsConsole(winw, winh);
	int[][] board = new int[SIZE][SIZE];
	boolean turnX = true;

	TicTacToe() {
		setupGraphics();

		//game loop
		while(true) { //FIXME we need to be able to win/lose
			if(gc.getMouseClick() > 0) {
				handleClick();
				counter++;
				if(counter == 9) {
					System.out.println("This game is a tie");
					gc.showDialog("This game is a tie", "Tie");
				}
			}
			drawGraphics();
			//turnCounter();
			gc.sleep(10);
		}
	}

	void setupGraphics() {
		gc.setTitle("TicTacToe");
		gc.setAntiAlias(true);
		gc.setStroke(2);
		gc.setLocationRelativeTo(null);
		gc.enableMouse(); //For clicking
		gc.setResizable(true); // <<<< Just DO It!
	}

	void handleClick() {
		int mx = gc.getMouseX();
		int my = gc.getMouseY();
		//        gc.setTitle(mx + ", " + my + "| " + boxW);
		int col = mx/boxW;
		int row = my/boxH;

		//1. Is this square empty? If not Return;

		if(board[row][col] != EMPTY) return;

		//2. put X or O in board
		if(turnX)board[row][col] = XX;
		else board[row][col] = OO;
		//3. Did player win?
		if (board[row][0]+board[row][1]+board[row][2] == 3||board[0][col]+board[1][col]+board[2][col] == 3||board[0][0]+board[1][1]+board[2][2] == 3||board[0][2]+board[1][1]+board[2][0] == 3) {
			//            gc.showDialog("X wins");

			System.out.println("X is the winner");
			gc.showDialog("X wins", "X is the winner");
			//             gc.setTitle("X wins");
			// gc.drawString("X is the winner!", 100, 100);
		}
		if (board[row][0]+board[row][1]+board[row][2] == -3||board[0][col]+board[1][col]+board[2][col] == -3||board[0][0]+board[1][1]+board[2][2] == -3||board[0][2]+board[1][1]+board[2][0] == -3) {
			System.out.println("O wins");
			gc.showDialog("O wins", "O is the winner");

		}
		//4. is it a tie?

		//5. Change Turn
		turnX = !turnX;
		//        printBoard();
	}

	void drawGraphics() {
		//recalc incase screen has been resized
		winw = gc.getDrawWidth();
		winh = gc.getDrawHeight();

		boxW = winw/SIZE;
		boxH = winh/SIZE;
		synchronized(gc) {

			//draw grid
			gc.clear();
			gc.setColor(new Color(50,30,60, 250));
			for(int i=0; i<=SIZE; i++) {
				gc.drawLine(i*boxW, 0, i*boxW, winh);
				gc.drawLine(0, i*boxH, winw, i*boxH);
			}

			//draw X or O
			gc.setColor(Color.RED);
			for(int row=0; row<SIZE; row++) {
				for(int col=0; col<SIZE; col++) {
					if(board[row][col] == XX) {
						gc.drawLine(col*boxW, row*boxH, (col+1)*boxW, (row+1)*boxH);
						gc.drawLine(col*boxW, (row+1)*boxH, (col+1)*boxW, row*boxH);
					}
					if (board[row][col] == OO) {
						gc.drawOval(col*boxW, row*boxH, boxW, boxH);
					}
				}
			}
		}
	}
}