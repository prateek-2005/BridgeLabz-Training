package healthclinicapp;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class VisitService {

    public static void recordVisit(Scanner sc) throws Exception {

        System.out.print("Appointment ID: ");
        int aid = sc.nextInt();
        sc.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = sc.nextLine();

        Connection con = DBUtil.getConnection();

        try {
            con.setAutoCommit(false);

            String visitSql = "INSERT INTO visits(appointment_id, diagnosis, visit_date) VALUES (?, ?, ?)";
            PreparedStatement ps1 = con.prepareStatement(visitSql);
            ps1.setInt(1, aid);
            ps1.setString(2, diagnosis);
            ps1.setDate(3, Date.valueOf(LocalDate.now()));
            ps1.executeUpdate();

            String updateSql = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";
            PreparedStatement ps2 = con.prepareStatement(updateSql);
            ps2.setInt(1, aid);
            ps2.executeUpdate();

            con.commit();
            System.out.println("Visit Completed");

        } catch (Exception e) {
            con.rollback();
            System.out.println("Transaction Failed");
        }
    }
}
