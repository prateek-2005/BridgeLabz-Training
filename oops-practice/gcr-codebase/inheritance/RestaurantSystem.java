class Person {
    String name;
    int id;
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println();
    }
}
interface Worker {
    void performDuties();
}
class Chef extends Person implements Worker {
    String specialty;
    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    @Override
    public void performDuties() {
        System.out.println("Chef");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Specialty: " + specialty);
        System.out.println();
    }
}
class Waiter extends Person implements Worker {
    String shift;
    Waiter(String name, int id, String shift) {
        super(name, id);
        this.shift = shift;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Shift: " + shift);
        System.out.println();
    }
}
public class RestaurantSystem {
    public static void main(String[] args) {
        Person p = new Person("Person", 101);
        Chef c = new Chef("Amit", 201, "Italian");
        Waiter w = new Waiter("Ramesh", 301, "Night");
        p.displayInfo();
        c.performDuties();
        w.performDuties();
    }
}