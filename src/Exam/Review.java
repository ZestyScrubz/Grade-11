package Exam;
import java.util.*;
public class Review {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter word: ");
		
		String word = sc.nextLine();
		
		System.out.println(word.substring(0,4));
	}

}
