import java.util.*;
import java.time.*;

class Policy {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public String toString() {
        return policyNumber + " " + holderName + " " + expiryDate + " " + coverageType + " " + premium;
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Policy> hashMap = new HashMap<>();
        LinkedHashMap<String, Policy> linkedHashMap = new LinkedHashMap<>();
        TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter PolicyNumber, Name, Expiry(yyyy-mm-dd), Coverage, Premium:");
        for (int i = 0; i < n; i++) {
            String pno = sc.nextLine();
            String name = sc.nextLine();
            LocalDate date = LocalDate.parse(sc.nextLine());
            String type = sc.nextLine();
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy p = new Policy(pno, name, date, type, premium);

            hashMap.put(pno, p);
            linkedHashMap.put(pno, p);

            treeMap.putIfAbsent(date, new ArrayList<>());
            treeMap.get(date).add(p);
        }

        System.out.print("Enter policy number to search: ");
        String searchNo = sc.nextLine();
        System.out.println("Found: " + hashMap.getOrDefault(searchNo, null));

        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("Policies expiring within 30 days:");
        for (Map.Entry<LocalDate, List<Policy>> e : treeMap.entrySet()) {
            if (!e.getKey().isBefore(today) && !e.getKey().isAfter(limit)) {
                for (Policy p : e.getValue()) {
                    System.out.println(p);
                }
            }
        }

        System.out.print("Enter policyholder name: ");
        String holder = sc.nextLine();

        System.out.println("Policies for holder:");
        for (Policy p : hashMap.values()) {
            if (p.holderName.equalsIgnoreCase(holder)) {
                System.out.println(p);
            }
        }

        Iterator<Map.Entry<String, Policy>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Policy p = it.next().getValue();
            if (p.expiryDate.isBefore(today)) {
                it.remove();
                linkedHashMap.remove(p.policyNumber);
            }
        }

        System.out.println("After removing expired policies:");
        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        sc.close();
    }
}
