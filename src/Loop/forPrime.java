package Loop;
import java.util.Scanner;
public class forPrime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number: ");
		int x = input.nextInt();
		input.close();
		boolean flag = false;
		
		for (int i = 2; i <= x / 2 ; i++) {
			if (x % i == 0) {
				flag = true;
				break;
				}
			}
		
		if (!flag) {
			System.out.println("This is a prime number");
		} else {
			System.out.println("This is not a prime number");
			
		}
 
	}

}
