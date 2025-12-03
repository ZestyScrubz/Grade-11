/*
 * Rock Paper Scissors Game
 * Isaac Tran
 * October 14 2022
 * A simple Rock Paper Scissors game between the user and the computer
 */
package Loop;
import java.util.*; //imports the entire util package
public class RPS {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		// store the player's and computer's move
		int userChoice, compChoice;
		// state if user wants to play or quit
		boolean play = true;
		// collect if the user wants to play or quit
		String decision = "";
		// win, lost, tie count
		int win = 0, lose = 0, tie = 0, rock = 0, paper = 0, sciss = 0;
		
		System.out.println("Let's Play Rock Paper Scissors!!");
		System.out.println("================================");
		
		// Main game loop
		while (play) {
			// display menu and prompt the user's choice
			System.out.println("Choose your throw: Rock - 1, Paper - 2, Scissors - 3");
			System.out.print("You choose: ");
			userChoice = input.nextInt();
			System.out.print(""); // empty space
			
			switch (userChoice) {
			case 1:
				System.out.println("ROCK vs. ...");
				rock++;
				break;
			case 2:
				System.out.println("PAPER vs. ...");
				paper++;
				break;
			case 3:
				System.out.println("SCISSORS vs. ...");
				sciss++;
				break;

			}
			
		// Determine and display the computer's move
			compChoice = rand.nextInt(3) + 1;
			switch (compChoice) {
			case 1:
				System.out.println("ROCK");
				break;
			case 2:
				System.out.println("PAPER");
				break;
			case 3:
				System.out.println("SCISSORS");
				break;
			}
			//Determine the winner
			if (userChoice == compChoice) {
				//Check for a tie
				System.out.println("It's a tie!");
				tie++;
			} else if ((userChoice == 1 && compChoice == 3) || (userChoice == 2 && compChoice == 1) || (userChoice == 3 && compChoice == 2)) {
				//User wins
				System.out.println("You win");
				win++;

			} else {
				//Computer wins
				System.out.println("You lose");
				lose++;
			}
			
			// Prompt the user to play again or quit
			while (true) {
				System.out.println("");
				System.out.print("Would you like to play again? [y]es or [n]o: ");
				decision = input.next();
				if (decision.equals("y")) {
					play = true;
					break;
				} else if (decision.equals("n")) {
					play = false; //The user wants to quit
					break;
				} else {
					System.out.println("Invalid chioce - Please choose 'y' or 'n'.");
					System.out.println("");
	
				}

			}
		}
		
		input.close();
		int total = win + lose + tie;
		System.out.println("Win: " + win);
		System.out.println("Lost: " + lose);
		System.out.println("Tie: " + tie);
		System.out.println("Total: " + total);
		System.out.println("");
		System.out.println(String.format("Win percentage: %.0f",((double)win / total) * 100) + "%");
		System.out.println(String.format("Lose percentage: %.0f",((double)lose / total) * 100) + "%");
		System.out.println(String.format("Tie percentage: %.0f",((double)tie / total) * 100) + "%");
		System.out.println("");
		
		// display the most common throw
		if ((rock > paper) && (rock > sciss)) {
			System.out.println("Your most common throw is rock");
		} else if ((paper > rock) && (paper > sciss)) {
			System.out.println("Your most common throw is paper");
		} else if ((sciss > rock) && (sciss > paper)) {
			System.out.println("Your most common throw is scissors");
		} else if (rock == paper && rock == sciss) {
			System.out.println("All common throw");
		} else if ((rock == paper) && (rock > sciss)) {
			System.out.println("Rock and Paper are the most common throw");
		} else if ((paper == sciss) && (paper > rock)) {
			System.out.println("Rock and Paper are the most common throw");
		} else if ((rock == sciss) && (rock > paper)) {
			System.out.println("Rock and Paper are the most common throw");
		}
		
		System.out.println("");
		System.out.println("Thanks for playing!");
		
	}
	
}
