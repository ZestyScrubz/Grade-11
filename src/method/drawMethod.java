package method;

public class drawMethod {

	static void drawBar(int length, String symbol) {
		for (int i = 0; i < length; i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		drawBar(2, "$");

	}
}
