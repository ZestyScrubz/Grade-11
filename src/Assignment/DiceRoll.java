package Assignment;
/*
 * Isaac Tran
 * It will simulate the rolling of a single dice. 
 * Once the simulation is complete, display how many times you rolled each total, and the percentage of times each value occurred.
 */
import java.util.Random;
public class DiceRoll {

	public static void main(String[] args) {
//		int roll[][] = new int[13][2]; // create an array size 13 row and size 2 column 
		
		int[] dices = new int[numRoll(2)];
		
		for (int i = 0 ; i < dices.length; i++)
		{
			dices[i] = (int)(Math.random()*6)+1;
			System.out.print(dices[i]+" ");
		}
		for (int j = 0 ; j < dices.length; j++)
		{
			dices[j] = (int)(Math.random()*6)+1;
			System.out.print(dices[j]+" ");
		}
		
		System.out.println(numRoll(2));
			}
	/**
	 * Roll a number between 1-6
	 * @return num return the dice number
	 */
	static int roll() {
		Random rand = new Random();
		int num;
		num = rand.nextInt(6) + 1;

		return num;
	}
	/**
	 * Roll a dice a certain number of time
	 * 
	 * @param numRoll Indicate how many dice to roll.
	 * @return total return the sum of all the dice
	 */
	static int numRoll(int numRoll) {
		int total = 0;
		for (int i = 0; i < numRoll; i++) {
			int num = roll();
			total += num;
			System.out.println("you rolled " + num);
		}

		return total;

	}

}

// did not know how to write the main method
