package Loop;

import java.util.Scanner;
public class factorial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, sum = 1, count;
		
		System.out.print("Enter number: ");
		n = input.nextInt();
		input.close();
		
		for (count = 1; count <= n; count++) {			
			sum *= count;
		}
		
		System.out.print(n +"! = " + sum);

	}

}
