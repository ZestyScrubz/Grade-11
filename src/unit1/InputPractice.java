/*
Input Practice
2022-09-22
Isaac Tran
*/
package unit1;

import java.util.Scanner;

public class InputPractice {

	public static void main(String[] args) {
		
		String name;
		int age;
		double number;
		Scanner myInput = new Scanner(System.in);
		System.out.print("What is your full name: ");
		name = myInput.nextLine();
		System.out.print("How old are you: ");
		age = myInput.nextInt();
		System.out.print("3/2 = ");
		number = myInput.nextDouble();
		myInput.close();

	}

}
