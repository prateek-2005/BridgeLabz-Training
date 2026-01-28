package musicplaylistmanager;
import java.util.*;

public class Manager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayList playlist = new PlayList();
        System.out.println("Welcome to Music Playlist Manager");
        System.out.println("Enter 1 to add song");
        System.out.println("Enter 2 to remove song");
        System.out.println("Enter 3 to find song");
        System.out.println("Enter 4 to play song");
        System.out.println("Enter 5 to find recently played song");
        System.out.println("Enter 0 to exit");

        while (true) {
            System.out.println("Enter Number to perform : ");
            int n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    System.out.println("Enter Song To be Added: ");
                    String songName = sc.nextLine();
                    System.out.println("Enter Singer Name: ");
                    String singer= sc.nextLine();
                    Song song = new Song(songName, singer);
                    try {
                        playlist.addSong(song);
                    } catch (SongAlreadyExistsException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Enter Song Name To Be Removed");
                    String name = sc.nextLine();
                    playlist.removeSong(name);
                    break;
                case 3:
                    System.out.println("Enter Song Name To Be Find");
                    String name1 = sc.nextLine();
                    playlist.findSong(name1);
                    break;
                case 4:
                    System.out.println("Enter Song Name To Be Played");
                    String name2 = sc.nextLine();
                    playlist.played(name2);
                    break;
                case 5:
                    playlist.findRecentlyPlayed();
                    break;
                case 0:
                    System.out.println("Exit From Music Player");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}