package Unit2;

import java.util.Scanner;
public class activity2_6 {
	public static void main(String[] args) {

		int year;
		Scanner input = new Scanner (System.in);
		System.out.print("What year were you born?: ");
		year = input.nextInt();
		input.close();
		if (year >= 2003 && year <= 2009) {
			System.out.print("You are a teenager");
		}
		if (year >= 2010) {
			System.out.println("Yor are an adult");
		}
		else {
			System.out.println("You are a child");
		}
	}
}
