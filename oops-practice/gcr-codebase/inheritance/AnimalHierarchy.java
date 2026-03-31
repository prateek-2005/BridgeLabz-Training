class Animal{
    String name;
    int age;
    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    void makeSound() {
        System.out.println("Animal Sounds");
    }
}
class Dog extends Animal{
    Dog(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    Cat(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println("Cat meows");
    }
}
class Bird extends Animal{
    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println("Bird Sounds");
    }
}
public class AnimalHierarchy {

    public static void main(String[] args) {
        Animal animal=new Animal("Animal",5);
        Dog dog=new Dog("Dog",10);
        Cat cat=new Cat("Cat",10);
        Bird bird=new Bird("Bird",10);
        animal.makeSound();
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }

}
