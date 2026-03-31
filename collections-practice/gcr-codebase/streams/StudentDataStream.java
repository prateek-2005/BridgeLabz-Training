import java.io.*;
public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "student.dat";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);              
            dos.writeUTF("Rahul");          
            dos.writeDouble(8.75);          
            dos.writeInt(102);
            dos.writeUTF("Anjali");
            dos.writeDouble(9.10);

            System.out.println("Student data written successfully.\n");

        } catch (IOException e) {
            System.out.println("Error while writing data.");
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Reading student data from file:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error while reading data.");
            e.printStackTrace();
        }
    }
}
