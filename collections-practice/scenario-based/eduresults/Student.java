package eduresults;
class Student {
    private int id;
    private String name;
    private int marks;
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getMarks() {
        return marks;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return id + " - " + name + " (" + marks + ")";
    }
}
