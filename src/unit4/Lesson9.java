package unit4;
import java.util.*;
public class Lesson9 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter age: ");
		int age = input.nextInt();
		
		if (age >= 16 && age < 18) {
			System.out.println("You can drive");
		} else if (age >= 18 && age < 19) {
			System.out.println("You can dirnk and drive");
		} else if (age >= 19) {
			System.out.println("You are very old");
		} else {
			System.out.println("You are young");
		}
	}

}
