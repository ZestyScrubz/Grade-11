package Practice;

public class Song {
	// class variable
	private String title;
	private String artist;
	private String year;
	private String info;
	
	Song(String title, String artist, String year) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.info = title + " by " + artist + " - released " + year;
	}
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getYear() {
		return year;
	}
	void info() {
		info = title + " by " + artist + " - released " + year;
	}
	void musicInfo() {
		System.out.println(title + " by " + artist + " - released " + year);
	}
}
