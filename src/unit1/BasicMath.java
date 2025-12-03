package unit1;

import java.util.Scanner;

public class BasicMath {

	
	public static void main(String[] args) {
		
		int x;
		int y;
		Scanner input = new Scanner(System.in);
		System.out.print("First number: ");
		x = input.nextInt();
		System.out.print("Second number: ");
		y = input.nextInt();
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y);
		
	}

}
