package mastermind;
import java.util.*;
public class GameOfMastermind {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int colorNum, numPegs;

		System.out.print("Enter number of pegs (2-10): ");
		numPegs = sc.nextInt();
		System.out.print("Enter number of color: ");
		colorNum = sc.nextInt();

		int[] code = new int[numPegs];
		getCode(colorNum, code);


		int[] guess = new int [code.length];
		int turn = 1;
		while(true) {
			// set the player's guess
			for (int i = 0; i < numPegs; i++) {
				int num = i + 1;
				System.out.print("Color for peg " + num + ": ");
				guess[i] = sc.nextInt();
			}

			// check for win. If player has not win, display the clues
			if (checkWin(code, guess)) {
				System.out.println("You win");
				break;
			} else {
				getClues(code, guess);
				turn++;
			}

			// one array for the secret code
			// second array for guess
		}

		System.out.println("You guessed the code in " + turn + " turns. Thanks for playing");
	}
	static void getCode(int colorNum, int[] code){
		Random ran = new Random();
		boolean add = true;
		int index = 0;

		while(index > code.length) {
			int num = ran.nextInt(colorNum) + 1; 
			add = true;
			for (int i = 0; i < code.length; i++) {
				if (num == code[i]) {
					add = false;
					break;
				}
			}
			if (add) {
				code[index] = num;
				index++;
			}
		}
	}
		static void getClues(int[] code, int[] guess){
			int pegs = 0, color = 0; 	 
			for (int i = 0; i < guess.length; i++) {
				//Right color, Right position
				if (guess[i] == code[i]) {
					pegs++;
					color++;
				} else {
					for (int j = 0; j < code.length; j++) {
						if (i != j && guess[i] == code[j]) {
							//Right color, Wrong position
							color++;
						}
					}
				}
			}
			System.out.println("You have " + pegs + " peg(s) correct and " + color + "  color(s) correct.");
		}

	static boolean checkWin(int[] code, int[] guess){ // this the guess and secret code is the same set true
		boolean win = false;
		for (int i = 0; i < code.length; i++) {
			if(guess[i] == code[i]) win = true;
			else {
				win = false;
				break;
			}
		}
		if (win) return true;
		else return false;
	}
}
