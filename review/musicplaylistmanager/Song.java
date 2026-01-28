package musicplaylistmanager;

public class Song {
	private String songName;
	private String singer;
	public Song(String songName,String singer) {
		this.songName=songName;
		this.singer=singer;
	}
	
	public String getSong() {
		return songName;
	}
	public String getSinger() {
		return singer;
	}
}
