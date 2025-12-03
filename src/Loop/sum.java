package Loop;

import java.util.Scanner;
public class sum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x, total = 0, count;
		
		System.out.print("Enter number: ");
		x = input.nextInt();
		input.close();
		
		for (count = 1; count <= x; count++) {
			System.out.println(count);
			total += count;
		}
		
		System.out.print("The sum is: " + total);

	}

}
