package Loop;

public class InfiniteLoop {

	public static void main(String[] args) {
		
		int even = 0;
		int odd = 0;
		
		System.out.println("All the even numbers between 1-20 are: ");
		
		while (true) {
			even++;
			if (even > 20) break; 
			if (even % 2 == 0) {
				System.out.println(even);
				continue;
			} 
		}
		
		System.out.println("All odd number between 1-20 are: ");
		
		while (true) {
			odd++;
			if (odd > 20) break;
			if (odd % 2 == 1) {
				System.out.println(odd);
				continue;
			}
		}	
		
	}

}
