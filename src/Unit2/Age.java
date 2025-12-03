package Unit2;

import java.util.Scanner;
public class Age {

	public static void main(String[] args) {
		
		int age;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Age: ");
		age = input.nextInt();
		if (age >= 18) {
			System.out.print("Welcome to the club");
	} else {
		System.out.print("Sorry you are underage");
	}

}
	
}
