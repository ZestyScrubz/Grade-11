package Unit2;

import java.util.Scanner;
public class activity2 {

	public static void main(String[] args) {
		
		int number;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Number: ");
		number = input.nextInt(); 
		input.close();
		if (number != 0) {
			if (number > 0) {
				System.out.print("Your number is positive");
			} else {
				System.out.print("Your number is negative");
			}
		} else {
			System.out.print("Your number is neither");
		}
		
	}

}
