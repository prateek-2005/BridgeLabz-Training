import java.util.*;
import java.time.*;
class Policy implements Comparable<Policy> {
    String policyNumber;
    String name;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(String policyNumber, String name, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.name = name;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return policyNumber.equals(p.policyNumber);
    }

    public int hashCode() {
        return policyNumber.hashCode();
    }

    public int compareTo(Policy p) {
        int c = this.expiryDate.compareTo(p.expiryDate);
        if (c == 0) return this.policyNumber.compareTo(p.policyNumber);
        return c;
    }

    public String toString() {
        return policyNumber + " " + name + " " + expiryDate + " " + coverageType + " " + premium;
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();

        HashSet<Policy> hashSet = new HashSet<>();
        LinkedHashSet<Policy> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Policy> treeSet = new TreeSet<>();

        ArrayList<String> policyNumbers = new ArrayList<>();

        System.out.println("Enter PolicyNumber, Name, Expiry(yyyy-mm-dd), Coverage, Premium:");
        for (int i = 0; i < n; i++) {
            String pno = sc.nextLine();
            String name = sc.nextLine();
            LocalDate date = LocalDate.parse(sc.nextLine());
            String type = sc.nextLine();
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy p = new Policy(pno, name, date, type, premium);

            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);

            policyNumbers.add(pno);
        }

        System.out.println("All Unique Policies (HashSet): " + hashSet);
        System.out.println("Insertion Order (LinkedHashSet): " + linkedHashSet);
        System.out.println("Sorted by Expiry (TreeSet): " + treeSet);

        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("Expiring within 30 days:");
        for (Policy p : hashSet) {
            if (!p.expiryDate.isBefore(today) && !p.expiryDate.isAfter(limit)) {
                System.out.println(p);
            }
        }

        System.out.print("Enter coverage type to search: ");
        String searchType = sc.nextLine();

        System.out.println("Matching policies:");
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(searchType)) {
                System.out.println(p);
            }
        }

        HashMap<String, Integer> freq = new HashMap<>();
        for (String s : policyNumbers) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        System.out.println("Duplicate policy numbers:");
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println(e.getKey());
            }
        }

        Policy test = new Policy("TEST100", "X", LocalDate.now().plusDays(10), "Health", 1000);

        long start, end;

        start = System.nanoTime();
        hashSet.add(test);
        end = System.nanoTime();
        System.out.println("HashSet add: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.add(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add: " + (end - start));

        start = System.nanoTime();
        treeSet.add(test);
        end = System.nanoTime();
        System.out.println("TreeSet add: " + (end - start));

        start = System.nanoTime();
        hashSet.contains(test);
        end = System.nanoTime();
        System.out.println("HashSet search: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.contains(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet search: " + (end - start));

        start = System.nanoTime();
        treeSet.contains(test);
        end = System.nanoTime();
        System.out.println("TreeSet search: " + (end - start));

        start = System.nanoTime();
        hashSet.remove(test);
        end = System.nanoTime();
        System.out.println("HashSet remove: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.remove(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet remove: " + (end - start));

        start = System.nanoTime();
        treeSet.remove(test);
        end = System.nanoTime();
        System.out.println("TreeSet remove: " + (end - start));

        sc.close();
    }
}
