package unit4;
import java.util.*;
public class String7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter text: ");
		String text = sc.nextLine(); // user's text
		
		String[] word = text.split(" ");
		
		System.out.println("The number of words in " + '"' + text + '"'+ " is " + word.length);
		
		
	}
}

