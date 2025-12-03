package KingFred;
import java.util.*;
public class King {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter word: ");
		String word = sc.nextLine();
		String translated = word.toUpperCase();

		if(translated.startsWith("DI")) {
			translated = translated.replaceFirst("DI", "ID");
		}
	//	if(translated.endsWith("ED")) {
		//	word.setChartAt(0,"ID");
	//	}
		
		if(word.length() == 4) {
			translated = "FRED";
		}

		System.out.print("Translated word: ");
		System.out.print(translated);
	}

}
