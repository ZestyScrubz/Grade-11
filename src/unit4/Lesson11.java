package unit4;
import java.util.*;
public class Lesson11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> grades = new ArrayList<Integer>();
		int sum = 0;
		while(true) {
			System.out.print("Enter grade (999 to quit): ");
			int grade = sc.nextInt();
			if (grade == 999) break;
			grades.add(grade);
		}

		// check if its biggest number and lowest number
		int max = grades.get(0), min = grades.get(0);
		int n = grades.size();
		for (int i = 0; i < n; i++) {
			if (grades.get(i) > max) {
				max = grades.get(i);
			}
		}
		for (int i = 0; i < n; i++) {
			if (grades.get(i) < min) {
				min = grades.get(i);
			}
		}
		
		for (Integer num: grades) {
			sum += num.intValue();
		}
		double avg = sum/grades.size();
		System.out.println("Average: " + avg);
		System.out.println("Higest mark: " + max);
		System.out.println("Lowest mark: " + min);
	}
}
