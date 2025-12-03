package unit5;
import java.util.*;
public class array1 {

	public static void main(String[] args) {
		Random r = new Random();

		int[] num = new int[25];
		System.out.print("EVEN: ");
		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt(100);
			if (num[i] % 2 == 0) {
				System.out.print(num[i] + " ");
			}
		}
		System.out.println();
		System.out.print("ODD: ");
		for (int i = 0; i < num.length; i++) {
			if (num[i] % 2 == 1) {
				System.out.print(num[i] + " ");
			}

		}
	}
}
