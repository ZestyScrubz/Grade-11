package Unit2;

/*
 * Isaac Tran
 * 2022-10-06
 * A Simple Calculator with 8 different operation
 */
import java.lang.Math;
import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		
		double x, y, z; //Variable for user's first, second and third number
		double answer; // Variable for the answer
		System.out.println("Welcome To The Simple Calculator Application");
		System.out.println("=============================================");
		System.out.println("1. Addition\t\t 5. Exponetioation"); //Display the list of Operation
		System.out.println("2. Subtraction\t\t 6. Square Root"); 
		System.out.println("3. Multiplication\t 7. Average"); 
		System.out.println("4. Division\t\t 8. Cosine"); 
		System.out.println("=============================================");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Which operation would you like to perform?: "); //Prompt the question
		int operation = input.nextInt(); //Collect the operation
		
		System.out.println("=============================================");
		
		switch (operation) {
			case 1:
				System.out.print("Enter First Number: ");
				x = input.nextDouble(); //Collect First number
				System.out.print("Enter Second Number: ");
				y = input.nextDouble(); //Collect Second Number
				answer = (x + y); //Add first and second number
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer); //Display answer
				break; //Escape out of the case
			case 2:
				System.out.print("Enter First Number: ");
				x = input.nextDouble();
				System.out.print("Enter Second Number: ");
				y = input.nextDouble();
				answer = (x - y); //Subtract first and second number and save it in "answer"
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			case 3: 
				System.out.print("Enter First Number: ");
				x = input.nextDouble();
				System.out.print("Enter Second Number: ");
				y = input.nextDouble();
				answer = (x * y); //Multiply first and second number and save it in "answer"
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			case 4:
				System.out.print("Enter First Number: ");
				x = input.nextDouble();
				System.out.print("Enter Second Number: ");
				y = input.nextDouble();
				answer = (x / y); //Divide first and second number and save it in "answer"
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			case 5:
				System.out.print("Enter Base Number: ");
				x = input.nextDouble();
				System.out.print("Enter Exponent Number: ");
				y = input.nextDouble();
				answer = (Math.pow(x, y)); //Take x, raised it to y
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			case 6: 
				System.out.print("Enter Number to square root: ");
				x = input.nextDouble();
				answer = (Math.sqrt(x)); //Square Root the number they inputed
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			case 7:
				System.out.print("Enter First Number: ");
				x = input.nextDouble();
				System.out.print("Enter Second Number: ");
				y = input.nextDouble();
				System.out.print("Enter Third Number: ");
				z = input.nextDouble();
				answer = ((x + y + z) / 3); //Add all three number and divide it by 3 since its only asking for 3 numbers
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			case 8:
				System.out.print("Enter Angle: ");
				x = input.nextDouble();
				y = Math.toRadians(x); //Converts users angle to radians
				answer = (Math.cos(y)); //Cosine the users angle
				System.out.println("=============================================");
				System.out.print("The answer is: " + answer);
				break;
			default:
				System.out.print("Invalid choice."); //If the user enters a number not in the list, output 'Invalid choice'
			input.close(); //close input
		}
	}

}
