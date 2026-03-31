import java.util.*;
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        HashMap<String, Integer> accounts = new HashMap<>();
        System.out.println("Enter account number and balance:");
        for (int i = 0; i < n; i++) {
            String acc = sc.next();
            int bal = sc.nextInt();
            accounts.put(acc, bal);
        }
        TreeMap<Integer, List<String>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Integer> e : accounts.entrySet()) {
            sortedByBalance.putIfAbsent(e.getValue(), new ArrayList<>());
            sortedByBalance.get(e.getValue()).add(e.getKey());
        }
        Queue<String> withdrawalQueue = new LinkedList<>();
        System.out.print("Enter number of withdrawal requests: ");
        int m = sc.nextInt();
        System.out.println("Enter account numbers for withdrawal:");
        for (int i = 0; i < m; i++) {
            withdrawalQueue.add(sc.next());
        }
        System.out.println("Accounts (HashMap): " + accounts);
        System.out.println("Sorted by Balance (TreeMap): " + sortedByBalance);
        System.out.println("Withdrawal Processing Order (Queue):");
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.remove();
            if (accounts.containsKey(acc)) {
                System.out.println("Processed: " + acc);
            } else {
                System.out.println("Invalid Account: " + acc);
            }
        }
        sc.close();
    }
}
