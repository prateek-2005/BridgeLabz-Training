class Person{
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    void displayRole(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println();
    }
}
class Teacher extends Person {
    String subject;
    Teacher(String name, int age,String subject) {
        super(name, age);
        this.subject=subject;
    }

    @Override
    void displayRole() {
        System.out.println("Teacher");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Subject: "+subject);
        System.out.println();
    }
}
class Student extends Person{
    String grade;
    Student(String name, int age,String grade) {
        super(name, age);
        this.grade=grade;
    }
    @Override
    void displayRole() {
        System.out.println("Student");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Grade: "+grade);
        System.out.println();
    }
}

class Staff extends Person{
    String dutyType;
    Staff(String name, int age,String dutyType) {
        super(name, age);
        this.dutyType=dutyType;
    }
    @Override
    void displayRole() {
        System.out.println("Staff");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Duty Type: "+dutyType);
        System.out.println();
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        Person p=new Person("Person",25);
        Teacher t=new Teacher("Amit",25,"Science");
        Student s=new Student("Prateek",20,"A");
        Staff st=new Staff("Ramesh",35,"Hygeine");
        p.displayRole();
        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
