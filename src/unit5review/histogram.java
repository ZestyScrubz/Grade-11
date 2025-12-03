package unit5review;
import java.util.*;
public class histogram {

	public static void main(String[] args) {
		int[] totals = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		for (int i = 0; i < 100; i++) {
			int total = rollDice();
			totals[total] += 1;
		}
		for (int i = 2; i < totals.length; i++) {
			System.out.print(i + "\t");
			drawBar(totals[i]);
		}
		
	}
	static int rollDice() {
		Random r = new Random();
		int sum = r.nextInt(6) + 1 + r.nextInt(6) + 1;
		return sum;
	}
	static void drawBar(int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("#");
		}
		System.out.println();
	}
	
}
