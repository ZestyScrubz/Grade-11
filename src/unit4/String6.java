package unit4;
import java.util.Scanner; 
public class String6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String text;

		System.out.print("Enter text: ");
		text = sc.nextLine();

		int vowel = 0;

		for (int i = 0; i < text.length(); i++) {

			if ((text.charAt(i) == 'a') || (text.charAt(i) == 'e') || (text.charAt(i) == 'i')
					|| (text.charAt(i) == 'o') || (text.charAt(i) == 'u')) {
				vowel++;
			}
		}
		System.out.println("There are " + vowel + " vowels in " + text + ".");
	}
}
