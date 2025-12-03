package Array;
import java.util.Scanner;
public class FriendName {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] friend = new String[3];

		for (int i = 0; i < friend.length; i++) {
			System.out.print("The name of your friends are: ");
			friend[i] = input.next();
		}
		System.out.println("You're friends are: ");
		for (int j = 0; j < friend.length; j++) {
			System.out.println(friend[j]);
		}
		
		input.close();
	}

}
