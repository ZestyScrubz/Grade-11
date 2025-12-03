package Unit2;

import java.util.Scanner;

public class Condition {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
	System.out.print("Please enter your first number: ");
	double x = input.nextDouble();
	System.out.print("Please enter an operator: ");
	String op = input.next();
	System.out.print("Please enter your second number: ");
	double y = input.nextDouble();
	
	if(op.equals("+")) {
		System.out.println(x + y);
	} else if(op.equals("-")) {
		System.out.println(x - y);
	} else if(op.equals("*")) {
		System.out.println(x * y);
	} else if(op.equals("/")) {
		System.out.println(x / y); 
	}else {
			System.out.println("Operator Invalid");
		}
	
	} 

}
