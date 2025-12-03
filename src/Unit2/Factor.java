package Unit2;
import java.util.*;
public class Factor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a integer: ");
		int x = input.nextInt();

		System.out.println("The factors of " + x + " are: ");
		int i = 1;

		while(i <= x) {
			if(x % i == 0) {
				System.out.print(i + ", ");
			} 
			
			i++;
		}

		input.close();
	}

}
