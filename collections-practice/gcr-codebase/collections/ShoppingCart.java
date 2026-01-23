import java.util.*;
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> priceMap = new HashMap<>();
        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        System.out.println("Enter item name and price:");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();

            priceMap.put(name, price);
            cart.put(name, price);
        }
        TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Integer> e : cart.entrySet()) {
            sortedByPrice.putIfAbsent(e.getValue(), new ArrayList<>());
            sortedByPrice.get(e.getValue()).add(e.getKey());
        }
        System.out.println("Prices (HashMap): " + priceMap);
        System.out.println("Cart Order (LinkedHashMap): " + cart);
        System.out.println("Sorted by Price (TreeMap): " + sortedByPrice);
        sc.close();
    }
}
