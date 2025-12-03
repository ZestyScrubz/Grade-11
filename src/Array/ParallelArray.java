package Array;
import java.util.*;
public class ParallelArray {

	public static void main(String[] args) {

		/*		
		int[][] num = { {1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10} };

		for (int i = 0; i < num.length; i++) {
			if (i == 0 ) System.out.print("ODD: ");
			else System.out.print("EVEN: ");
			for (int j = 0; j < num[0].length; j++)
				System.out.print(num[i][j] + " ");
		}
		System.out.println();*/

		int[][] num = new int [2][5];
		int i = 0, j = 0;
		Scanner input = new Scanner(System.in);

		while (i < 5 || j < 5) {
			System.out.print("Enter a number between 1-100: ");
			int n = input.nextInt();
			if (n % 2 == 0 && i < 5) {
				num[1][i] = n;
				i++;
			} else if (n % 2 == 1 && j < 5) {
				num [0][j] = n;
				j++;
			}
		}
		for (i = 0; i < num.length; i++) {
			if (i == 0) System.out.print("EVEN: ");
			else System.out.print("ODD: ");
			for (j = 0; j < num[0].length; j++) {
				System.out.println(num[i][j]);
			}

		}
	}
}

