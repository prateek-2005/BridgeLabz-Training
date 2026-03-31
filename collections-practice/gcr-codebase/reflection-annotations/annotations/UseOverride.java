package annotations;
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class UseOverride {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
