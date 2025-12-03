package Loop;
import java.util.Scanner;
public class GuessingGame {

	public static void main(String[] args) {
		
		int count = 0;
		
		Scanner input = new Scanner(System.in);

		
		for (int answer = 6; count <= 10; count++) {
			
			System.out.print("Enter number: ");
			int guess = input.nextInt();

			if (guess == answer) {
				System.out.print("You got it");
				break;
			} else if (guess > answer) {
				System.out.println("too high!");
				continue;
			} else if (guess < answer){
				System.out.println("too low!");
			continue;
			}
		}
		
		System.out.println("You suck");
		input.close();
	}

}
