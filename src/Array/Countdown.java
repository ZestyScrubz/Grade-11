package Array;

public class Countdown {

	public static void main(String[] args) {
		int num[] = {1, 2, 3, 4, 5, 6, 7, 8 , 9, 10};
		
		for (int i = num.length - 1; i >= 0; i-- ) {
			System.out.println(num[i]);
		}
		System.out.println("GO!");
	}

}
