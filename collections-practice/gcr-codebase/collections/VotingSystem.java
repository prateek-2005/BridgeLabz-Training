import java.util.*;
public class VotingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of votes: ");
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> voteCount = new HashMap<>();
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
        System.out.println("Enter candidate names for each vote:");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            voteCount.put(name, voteCount.getOrDefault(name, 0) + 1);
            if (!voteOrder.containsKey(name)) {
                voteOrder.put(name, 1);
            } else {
                voteOrder.put(name, voteOrder.get(name) + 1);
            }
        }
        TreeMap<String, Integer> sortedResult = new TreeMap<>(voteCount);
        System.out.println("Vote Count (HashMap): " + voteCount);
        System.out.println("Vote Order (LinkedHashMap): " + voteOrder);
        System.out.println("Sorted Result (TreeMap): " + sortedResult);

        sc.close();
    }
}
