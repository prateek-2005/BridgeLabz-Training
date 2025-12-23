import java.util.*;
public class Cards {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	     String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
	                          "Jack", "Queen", "King", "Ace"};
	     String[] deck = initialize(suits, ranks);
	     shuffle(deck);
	     int NumberOfCards=sc.nextInt();
	     int NumberOfPlayers=sc.nextInt();
	     if(NumberOfCards>deck.length) {
	    	 System.out.println("Not Enough Cards To Play The Game");
	    	 sc.close();
	    	 return;
	     }
	     String[][] Cards = distribute(deck,NumberOfCards,NumberOfPlayers);
	     if(Cards!=null) {
	    	 for (int i = 0; i <Cards.length; i++) {
	             System.out.println("\nPlayer " + (i + 1) + ":");
	             for (int j = 0; j <Cards[i].length; j++) {
	                 System.out.println(Cards[i][j]);
	             }
	         }
	     }
	     sc.close();
	}
	public static String[] initialize(String[] suits, String[] ranks) {
        int NumberOfCards= suits.length*ranks.length;
        String[] arr= new String[NumberOfCards];
        int count= 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                arr[count++] = rank + " of " + suit;
            }
        }
        return arr;
    }
	public static void shuffle(String[] deck) {
        int n = deck.length;
        for (int i=0;i<n;i++) {
            int randomCard=i+(int)(Math.random()*(n - i));
            String temp = deck[i];
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
    }
	public static String[][] distribute(String[] deck, int NumberOfCards, int NumberOfPlayers) {
        if (NumberOfCards%NumberOfPlayers!= 0) {
            System.out.println("Cards cannot be distributed");
            return null;
        }

        int PlayersCards=NumberOfCards/NumberOfPlayers;
        String[][] ans= new String[NumberOfPlayers][PlayersCards];

        int index = 0;
        for (int i=0;i<NumberOfPlayers;i++) {
            for (int j = 0; j < PlayersCards; j++) {
                ans[i][j] = deck[index++];
            }
        }
        return ans;
    }
}
