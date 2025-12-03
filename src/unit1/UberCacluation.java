package unit1;

import java.util.Scanner;

public class UberCacluation {

	public static void main(String[] args) {
		double CF, FR, GS, pizza, drink, fee, tax;
		fee = 5.00;
		tax = 1.13;		
		Scanner input = new Scanner(System.in);
		System.out.println("====================");
		System.out.println("Welcome to Java Eats");
		System.out.println("====================");
		System.out.println ("Let\'s get your order together for you. Please indicate how many of each food item you would like to order."
				+ "\nIf you do not want an item, please enter 0.\r\n");
		System.out.println("Options: ");
		System.out.println("====================");
		System.out.print("Cheese Burger and Fries: ");
		CF = input.nextDouble();
		CF = (CF * 8.99);
		System.out.print("Falafel and Rice Plate : ");
		FR = input.nextDouble();
		FR = (FR * 9.99);
		System.out.print("Greek Salad Supreme: ");
		GS = input.nextDouble();
		GS = (GS * 8.49);
		System.out.print("Personal pizza: ");
		pizza = input.nextDouble();
		pizza = (pizza * 7.99);
		System.out.print("Drinks: ");
		drink = input.nextDouble();
		drink = (drink * 2.49);
		input.close();
		System.out.println("====================");
		System.out.print("With tax and delivery, your total is: $");
		System.out.println((CF + FR + GS + pizza + drink) * tax + fee);
		System.out.print("Thanks for ordering with Java Eats");
/*
		Scanner input = new Scanner(System.in);
		System.out.print("Cheese Burger and Fries: ");
		CF = input.nextDouble();
		System.out.print("Falafel and Rice Plate : ");
		FR = input.nextDouble();
		System.out.print("Greek Salad Supreme: ");
		GS = input.nextDouble();
		System.out.print("Personal pizza: ");
		pizza = input.nextDouble();
		System.out.print("Drinks: ");
		drink = input.nextDouble();
		double total = (CF * 8.99) + (FR * 9.99) + (GS * 8.49) + (pizza * 7.99) + (drink * 2.49);
		//Tax before fee
		total = total + tax;
		//add fee
		total = total + fee;
		System.out.print(total);
		input.close();
*/	
	}

}
