import java.util.*;
public class SnakeAndLadder {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Enter 1 To Play Player Vs Computer Or 2 To Play 1V1 Mode");
        int Mode = sc.nextInt();
        sc.nextLine();
        if (Mode == 1) {
            PlayerVsComputer();
        } else {
            Player1VsPlayer2();
        }
    }
    public static void PlayerVsComputer() {
        // UC 1
        System.out.println("Snake and Ladder game played with single player at start position 0");

        int CurrentPosition = 0;
        int DiceCount = 0;

        // UC 4 & UC 5
        while (CurrentPosition < 100) {
            System.out.println("Enter Exit to exit the game or Press any key to continue:");
            String Continue = sc.nextLine();
            if (Continue.equalsIgnoreCase("Exit")) {
                break;
            }
            // UC 2
            int Dice = (int)(Math.random() * 6) + 1;
            DiceCount++;
            // UC 3
            int PlayingOption = (int)(Math.random() * 3);
            if (PlayingOption == 0) {
            }
            else if (PlayingOption == 1) {
                CurrentPosition += Dice;
            }
            else {
                CurrentPosition -= Dice;
            }

            // UC 4
            if (CurrentPosition < 0) {
                CurrentPosition = 0;
            }
            if (CurrentPosition > 100) {
                CurrentPosition -= Dice;
            }
            System.out.println("Dice: " + Dice + " Current Position: " + CurrentPosition);
        }
        System.out.println("Game Won!!!");
        System.out.println("Number Of Times Dice Rolled: " + DiceCount);
    }
    public static void Player1VsPlayer2() {
        int CurrentPosition1 = 0;
        int CurrentPosition2 = 0;
        int DiceCount = 0;
        // Use-Case 4 && Use-Case 5
        while (CurrentPosition1 < 100 && CurrentPosition2 < 100) {
            System.out.println("Enter Exit to exit the game or Press any key to continue:");
            String Continue = sc.nextLine();
            if (Continue.equalsIgnoreCase("Exit")) {
                break;
            }
            // -------- Player 1 --------
            //Use-Case 2
            int Dice = (int)(Math.random() * 6) + 1;
            DiceCount++;
            //Use-Case 3
            int PlayingOption = (int)(Math.random() * 3);
            String Play = " ";
            if (PlayingOption == 0) {
                Play = "NoPlay";
            }
            else if (PlayingOption == 1) {
                Play = "Ladder";
            }
            else {
                Play = "Snake";
            }
            if (Play.equals("Ladder")) {
                CurrentPosition1 += Dice;
            }
            else if (Play.equals("Snake")) {
                CurrentPosition1 -= Dice;
            }
            if (CurrentPosition1 < 0) {
                CurrentPosition1 = 0;
            }
            else if (CurrentPosition1 > 100) {
                CurrentPosition1 -= Dice;
            }
            System.out.println("Player 1 Dice: " + Dice +
                    " Player 1 Current Position: " + CurrentPosition1);

            if (CurrentPosition1 == 100) {
                break;
            }
            // -------- Player 2 --------
            //Use-Case 2
            Dice = (int)(Math.random() * 6) + 1;
            DiceCount++;
            //Use-Case 3
            PlayingOption = (int)(Math.random() * 3);
            if (PlayingOption == 0) {
                Play = "NoPlay";
            }
            else if (PlayingOption == 1) {
                Play = "Ladder";
            }
            else {
                Play = "Snake";
            }
            if (Play.equals("Ladder")) {
                CurrentPosition2 += Dice;
            }
            else if (Play.equals("Snake")) {
                CurrentPosition2 -= Dice;
            }
            if (CurrentPosition2 < 0) {
                CurrentPosition2 = 0;
            }
            else if (CurrentPosition2 > 100) {
                CurrentPosition2 -= Dice;
            }
            System.out.println("Player 2 Dice: " + Dice +
                    " Player 2 Current Position: " + CurrentPosition2);
        }

        // Use-Case 6 && Use-Case 7
        if (CurrentPosition1 == 100) {
            System.out.println("Winner: Player 1");
        }
        else if (CurrentPosition2 == 100) {
            System.out.println("Winner: Player 2");
        }
        else {
            System.out.println("Game exited by user");
        }
        System.out.println("Total number of dice rolls: " + DiceCount);
        System.out.println("Final Position Player 1: " + CurrentPosition1);
        System.out.println("Final Position Player 2: " + CurrentPosition2);
    }
}
