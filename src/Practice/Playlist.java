package Practice;
import java.util.*;

import Assignment2.Student;
public class Playlist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Song> songs = new ArrayList<Song>();
		
		boolean play = true;
		
		while(play) {
			// display welcoming and the rules
			System.out.println("1. Add a song");
			System.out.println("2. Remove a song");
			System.out.println("3. Show playlist");
			System.out.println("4. Quit");
			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();
			System.out.println("-----------------------------");
			
			if(choice == 1) {
				System.out.print("Enter title: ");
				String title = sc.nextLine();
				
				System.out.print("Enter artist: ");
				String artist = sc.nextLine();
				
				System.out.print("Enter year: ");
				int year = sc.nextInt();
				
				String info = title + " by " + artist + " - released " + year;
				
				// access the student class
				Song Songs = new Song(title, artist, String.valueOf(year));
				songs.add(Songs);
				continue;
			} else if (choice == 2) {
				songs.remove(songs);
				continue;
			} else if (choice == 3) {
				// for the number of student, display all enrolled student's info from Student class
				for (Song info : songs) {
					info.musicInfo();
				}
				continue;
			}
		}
	}
}
