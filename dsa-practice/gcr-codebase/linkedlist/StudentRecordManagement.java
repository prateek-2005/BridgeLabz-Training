class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    StudentNode head = null;
    StudentNode tail = null;
    int size = 0;
    public void addAtBeginning(StudentNode node) {
        if (head == null) {
            head = tail = node;
        } 
        else {
            node.next = head;
            head = node;
        }
        size++;
    }
    public void addAtEnd(StudentNode node) {
        if (head == null) {
            head = tail = node;
        } 
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public void addAtSpecific(StudentNode node, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            addAtBeginning(node);
            return;
        }

        if (index == size) {
            addAtEnd(node);
            return;
        }

        StudentNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }
    public void delete(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            size--;
            if (head == null) {
            	tail = null;
            }
            return;
        }

        StudentNode current = head;
        while (current.next != null) {
            if (current.next.rollNumber == rollNumber) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }

        System.out.println("Student not found");
    }
    public void search(int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println(temp.rollNumber + "\t" +temp.name + "\t" + temp.age + "\t" + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
    public void display() {
        if (head == null) {
            System.out.println("No student records available");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + "\t" +temp.name + "\t" +temp.age + "\t" +temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public static void main(String[] args) {
        StudentRecordManagement student = new StudentRecordManagement();

        student.addAtBeginning(new StudentNode(1, "Prateek", 20, "A"));
        student.addAtEnd(new StudentNode(2, "Dipanshu", 21, "B"));
        student.addAtSpecific(new StudentNode(3, "Ayush", 22, "A"), 1);
        student.addAtSpecific(new StudentNode(4, "Kartik", 25, "A"), 2);

        student.delete(3);
        student.display();

        System.out.println("\nSearch By Roll Number:");
        student.search(2);

        student.updateGrade(2, "A+");
        student.display();
    }
}
