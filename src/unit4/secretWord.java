package unit4;

import java.util.*;

public class secretWord {
	static Random r = new Random();
	
	private static final String[] WORD_BANK = {"valorant", "cheese", "alone", "friends"};
	private static String word;
	private static char[] clue;

	void SecretWord() {
		int index = r.nextInt(WORD_BANK.length);
		word = WORD_BANK[index];	//selects secret word at random
		
		//Generate a clue of '_' of same length as word
		clue = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			clue[i] = '_';
		}
	}
		

	boolean guessedLetterInWord(char guess) {
		char[] letter = word.toCharArray();
		for(int i = 0; i < letter.length; i++) {
			if (letter[i] == guess) return true;
			else continue;
		}
		return false;
	}
	
	
	// If the guessed letter is in the clue, update it to include that letter
	void updateClue(char guess) {
		if(guessedLetterInWord(guess)) {
			for(int i = 0; i < word.length(); i++) {
				if(word.charAt(i) == guess) {
					clue[i] = guess;
				}
			}
		}
	}
	
	String getWord() {
		return word;
	}
	
	void displayClue(){
		for(int i = 0; i < clue.length; i++) {
			System.out.println(clue[i] + " ");
		}
		System.out.println();
	}
	
	boolean checkWin() {
		if(word.equals(String.valueOf(clue))) return true;
		else return false;
	}
	
}
