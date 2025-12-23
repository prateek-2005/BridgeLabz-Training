import java.util.*;

public class RockPaperScissors {
    public static String get() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }
    public static String find(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        }
        if ((user.equals("Rock") && computer.equals("Scissors")) ||(user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }
    public static String[][] Stats(int userWins, int compWins, int totalGames) {
        String[][] stats = new String[2][3];
        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f", compPercent);
        return stats;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[][] games = new String[n][3];
        int userWins = 0, compWins = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();
            String computerChoice = get();
            String winner = find(userChoice, computerChoice);
            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                compWins++;
            games[i][0] = userChoice;
            games[i][1] = computerChoice;
            games[i][2] = winner;
        }
        String[][] stats = Stats(userWins, compWins, n);
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + "\t" + games[i][0] + "\t" + games[i][1] + "\t\t" + games[i][2]);
        }
        System.out.println("\nWinning Statistics:");
        System.out.println("Player\tWins\tWin %");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
        sc.close();
    }
}
