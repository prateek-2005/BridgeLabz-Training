import java.util.*;
class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}
public class GroupDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> list = new ArrayList<>();
        System.out.println("Enter name and department:");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String dept = sc.nextLine();
            list.add(new Employee(name, dept));
        }
        HashMap<String, ArrayList<Employee>> map = new HashMap<>();
        for (Employee e : list) {
            if (!map.containsKey(e.department)) {
                map.put(e.department, new ArrayList<>());
            }
            map.get(e.department).add(e);
        }
        System.out.println(map);
        sc.close();
    }
}
