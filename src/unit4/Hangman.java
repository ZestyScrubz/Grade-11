package unit4;
import java.util.*;
public class Hangman {

	/**
	 * Displays the appropriate ASCII art Hangman image
	 * @param incorrectGues  The count of how many wrong guesses were made
	 */

	static void showHangman(int incorrectGuess) {
		String hangman = "";
		switch(incorrectGuess) {
		case 0:
			hangman = """
					 +--+
						 |  |
					  	    |
					    |
					    |
					    |
					=====
						""";
		case 1:
			hangman = """
					 +--+
						 |  |
					  	 O  |
					    |
					    |
					    |
					=====
						""";
		case 2:
			hangman = """
					 +--+
						 |  |
					  	 O  |
					 |  |
					    |
					    |
					=====	
						""";
		case 3:
			hangman = """
					 +--+
						 |  |
					  	 O  |
					/|  |
					    |
					    |
					=====
						""";
		case 4:
			hangman = """
					 +--+
						 |  |
					  	 O  |
					/|\\ |
					    |
					    |
					=====
						""";
		case 5:
			hangman = """
						 +--+
					 	 |  |
					   	 O  |
						/|\\ |
						/   |
						    |
						=====

					""";
		case 6:
			hangman = """
					 +--+
						 |  |
					  	 O  |
					/|\\ |
					/ \\ |
					    |
					=====
						""";
		default:
			hangman = "Something went wrong";
		}

		System.out.println(hangman);
	}

	public static void main(String[] args) {

		//setup
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int incorrectGuess = 0; // count number of incorrect guess
		String missedLetters = ""; // keep track of missed letter
		char guess; // for storing the user's guessed letter
		secretWord secret = new secretWord(); // the secret word to be guessed in the game



		//Welcome and Rule


		//Main game loop
		while (incorrectGuess < 6) {
			showHangman(incorrectGuess);
			if (incorrectGuess == 6) {
				// You've hanged the man. so game is over
				System.out.println("You've hanged the man");
				System.out.println("The secret word was: " + secret.getWord());
				break;
			}
			
			//We play a round if the player hasn't yet lost
			System.out.println("\nMissed letters: " + missedLetters);
			//Display clue
			secret.displayClue();
			
			//Get users guess and check if it is in secret word or not. Update clues and missed letter accordingly
			System.out.print("Guess letter: ");
			String temp = sc.next();
			temp = temp.toLowerCase();
			guess = temp.charAt(0);
		}
	}
}


