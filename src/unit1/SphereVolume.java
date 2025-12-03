package unit1;
//Import the classes
import java.util.Scanner;
import java.lang.Math;
public class SphereVolume {

	public static void main(String[] args) {
		
		//add the variables
		double radius, pi;
		pi = 3.1415926535897932384626433;
		
		//add scanner
		Scanner input = new Scanner(System.in);
		System.out.print("radius: ");
		radius = input.nextDouble(); 
		double diameter = (2 * radius); //set diameter variable
		diameter = Math.pow(diameter, 3);
		double volume = (diameter * pi / 6); //Can use: volume = (pi*Math.pow(diameter, 3.0))/6.0;
		input.close(); //close the scanner
		System.out.print("The volume of your sphere is: ");
		System.out.print(volume);

	}

}
