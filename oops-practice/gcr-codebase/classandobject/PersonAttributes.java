class Person{
	String name;
	int age;
	//Parameterized Constructor
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	//Copy Constructor
	Person(Person p){
		this.name=p.name;
		this.age=p.age;
	}
	void Display() {
		System.out.println("Person Name: "+name+" and Age: "+age);
	}
}
public class PersonAttributes {

	public static void main(String[] args) {
		Person p=new Person("Prateek",20);//Parameterized Constructor invoked
		Person p1=new Person(p);//Copy Constructor invoked
		p.Display();
		p1.Display();
	}

}
