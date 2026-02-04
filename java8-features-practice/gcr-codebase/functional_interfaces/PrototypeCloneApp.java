package functional_interfaces;
class Prototype implements Cloneable {
    int id;
    String name;

    Prototype(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class PrototypeCloneApp {

    public static void main(String[] args) {

        try {
            Prototype original = new Prototype(1, "Template Object");

            Prototype copy = (Prototype) original.clone();

            original.display();
            copy.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}
