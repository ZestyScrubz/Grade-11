package unit1;
//import classes
import java.lang.Math;
import java.util.Scanner;
public class TrigFrunction {

	public static void main(String[] args) {
		
		double angleDegree; //the user's angle in deg
		double angleRadians; //the user's angle in rad
		double angle; //final answer
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an angle in degrees: ");
		angleDegree = input.nextDouble(); 
		angleRadians = Math.toRadians(angleDegree);

		angle = Math.sin(angleRadians);
		System.out.print("Sine: ");
		System.out.println(angle);

		angle = Math.sin(angleRadians);
		System.out.print("Cosine: ");
		System.out.println(angle);
	
		angle = Math.sin(angleRadians);
		System.out.print("Tangent: ");
		System.out.println(angle);
		input.close();//Close the scanner
	}

}
