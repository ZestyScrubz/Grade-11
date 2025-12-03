package unit1;
//import both classes
import java.lang.Math;
import java.util.Scanner;

public class Volume {

	public static void main(String[] args) {
		//set variable for length, width, height
		double length, width, height;
		
		//add the scanner
			Scanner input = new Scanner(System.in);
			System.out.print("Length: ");
			length = input.nextDouble(); 
			System.out.print("Width: ");
			width = input.nextDouble(); 
			System.out.print("Height: ");
			height = input.nextDouble();
			double volume = (length * width * height);
			input.close(); //close the scanner
			volume = Math.round(volume); //round the total
			System.out.print("The volume of your rectangular prism is: ");
			System.out.print(volume);
	}

}
