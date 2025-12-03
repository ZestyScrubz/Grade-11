package Loop;

import java.util.Random;
public class GuessGame {
	public static void main(String[] args) {
		int guessMe = 7;
		int number = 0;
		Random rand = new Random();
		while (number != guessMe) {
			number = rand.nextInt(10) + 1;
			System.out.println("Guess: " + number);
			if (number > guessMe) {
				System.out.println("too high!");
			} else if (number < guessMe){
				System.out.println("too low!");
			}
		}
		
		System.out.print("Found it!");
	}

}

