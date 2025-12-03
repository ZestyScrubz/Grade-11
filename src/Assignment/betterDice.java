package Assignment;
import java.util.Random;
public class betterDice {
	/**
	 * Simulates rolling a single die
	 * @return	Returns the value rolled as an integer between 1 and 6
	 */
	static int roll() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}

	/**
	 * Simulates rolling a given number of dice to get the total
	 * @param numDice	The integer number of dice to be rolled
	 * @return	The total after rolling numDice dice
	 */
	static int rollDice(int numDice) {
		int total = 0;
		for (int i = 0; i < numDice; i++) {
			total += roll();
		}
		return total;
	}

	public static void main(String[] args) {
		/* Create 2 parallel arrays to count the total when 2 dice are rolled and 
		 * the percentage of time each total was rolled. The counter array will have
		 * all values initialized to 0. The size of each array will be 13.
		 */
		//Counts how many times each index value rolled
		int[] totals = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] percent = new int[13];	//percentage of times each value rolled

		//Simulate the rolling of a pair (i.e. 2) of dice 1000 times. 
		for (int i = 0; i < 1000; i++) {
			int total = rollDice(2);	 //roll 2 dice and get the total
			totals[total] += 1;	//increase the count for number of times total rolled
		}

		/*
		 * Calculate the percentage of times each number 2 - 12 was rolled in 1000 rolls.
		 * Display the results of roll total (2-12), number of times it was rolled,
		 * and the percentage of all rolls.
		 */
		for (int i = 2; i < percent.length; i++) {
			System.out.println(i + "  " + totals[i]);
		}
	}
}
