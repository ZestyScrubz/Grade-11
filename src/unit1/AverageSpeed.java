package unit1;

import java.util.Scanner;
public class AverageSpeed {

	public static void main(String[] args) {
		
		int distance, time; //create variable

		Scanner input = new Scanner(System.in);
		System.out.print("Distance traveled (in km): ");
		distance = input.nextInt();
		
		System.out.print("Time taken: ");
		time = input.nextInt();
		
		distance /= time;
		System.out.println("Average speed: " + (int)distance + "km/h");
	}

}
