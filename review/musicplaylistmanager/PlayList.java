package musicplaylistmanager;
import java.util.*;
public class PlayList {
    private LinkedList<Song> order;
    private Set<Song> songs;
    private Stack<Song> recentlyPlayed;

    public PlayList() {
        order = new LinkedList<>();
        songs = new HashSet<>();
        recentlyPlayed = new Stack<>();
    }

    public void addSong(Song song) throws SongAlreadyExistsException {
        if (songs.contains(song)) {
            throw new SongAlreadyExistsException("Song already exists in the playlist");
        }
        order.add(song);
        songs.add(song);
    }

    public void findSong(String name) {
        for (Song s : order) {
            if (s.getSong().equalsIgnoreCase(name)) {
                System.out.println("Song found: " + s.getSong());
                return;
            }
        }
        System.out.println("Song not found in the playlist");
    }

    public void removeSong(String name) {
        Song removed = null;
        for (Song s : order) {
            if (s.getSong().equalsIgnoreCase(name)) {
                removed = s;
                break;
            }
        }
        if (removed != null) {
            order.remove(removed);
            songs.remove(removed);
            System.out.println("Song removed: " + removed.getSong());
        } else {
            System.out.println("Song not found");
        }
    }

    public void played(String name) {
        for (Song s : order) {
            if (s.getSong().equalsIgnoreCase(name)) {
                recentlyPlayed.push(s);
                System.out.println("Playing: " + s.getSong());
                return;
            }
        }
        System.out.println("Song does not exist in the playlist");
    }

    public void findRecentlyPlayed() {
        if (recentlyPlayed.isEmpty()) {
            System.out.println("No songs have been played");
        } else {
            Song recent = recentlyPlayed.pop();
            System.out.println("Recently Played: " + recent.getSong());
        }
    }
}