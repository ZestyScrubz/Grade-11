package nim;
import java.util.Scanner;
import java.util.Random;
public class Game {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the game of Nim.\r\n"
				+ "There will be 15 - 30 stones selected for a game.\r\n"
				+ "You will take turns with your opponent drawing stones. Whoever draws the last stone loses.\r\n"
				+ "You can draw 1, 2, or 3 stones. You cannot draw more stones than there are left in the game.");

		boolean play = true;


		while (play) {
			int numStones = rand.nextInt(16) + 15;
			System.out.println("---------------------------------------------------------------------------------------------------------");

			while(numStones > 0) { 
				numStones = playerDraw(numStones);
				if (checkLoss(numStones)) {
					System.out.println("You lose");
					break;
				}
				numStones = compDraw(numStones);
				if (checkLoss(numStones)) {
					System.out.println("You win");
					break;
				}
			} 

			System.out.println("Do you want to play again? Press Q to quit: ");
			String again = input.next();
			if (again.equals("Q") || again.equals("q")) play = false;

		}
	}

	static int playerDraw(int numStones) {
		Scanner input = new Scanner(System.in);

		int draw;

		while (true) {
			System.out.print("There are " + numStones + ". How many stones would you like to take? ");
			draw = input.nextInt();
			if (isValidMove(numStones, draw)) {
				break;
			} else {
				System.out.println("Invalid - Choose 1 , 2, or 3");
			}
		}
		numStones -= draw;
		return numStones;
	}
	static int compDraw(int numStones) {
		Random r = new Random();

		int draw;

		do {
			draw = r.nextInt(3) + 1;
		} while (!isValidMove(numStones, draw));
		System.out.println("There are " + numStones + " stones left.\nThe computer takes " + draw + " stones");
		numStones -= draw;
		return numStones;
	}
	
	static boolean checkLoss(int numStones) {
		if (numStones <= 0) return true;
		else return false;
	}
	
	static boolean isValidMove(int numStones, int draw) {
		if (draw < 1 || draw > numStones || draw > 3) return false;
		else if (draw > numStones) return false;
		return true;
	}
}
