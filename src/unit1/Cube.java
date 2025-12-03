package unit1;

import java.lang.Math;
import java.util.Scanner;
public class Cube {

	public static void main(String[] args) {
		//Get the information of the user
		Scanner input = new Scanner(System.in);
		System.out.print("Length of each line: ");
		double s = input.nextInt();
		System.out.print("The volume is: ");
		double volume = Math.pow(s, 3.0);
		System.out.print(volume);
		input.close();
	}
}
