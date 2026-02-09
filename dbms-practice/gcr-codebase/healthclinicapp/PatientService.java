package healthclinicapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PatientService {

    public static void registerPatient(Scanner sc) throws Exception {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO patients(name, phone, email) VALUES (?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.executeUpdate();

            System.out.println("Patient Registered Successfully");
        }
    }
}
