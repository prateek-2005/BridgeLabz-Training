package healthclinicapp;
import java.sql.*;
import java.util.Scanner;

public class AppointmentService {

    public static void bookAppointment(Scanner sc) throws Exception {

        System.out.print("Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Time (HH:MM:SS): ");
        String time = sc.nextLine();

        String sql = "INSERT INTO appointments(patient_id, doctor_id, app_date, app_time, status) " +
                     "VALUES (?, ?, ?, ?, 'SCHEDULED')";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pid);
            ps.setInt(2, did);
            ps.setDate(3, Date.valueOf(date));
            ps.setTime(4, Time.valueOf(time));
            ps.executeUpdate();

            System.out.println("Appointment Booked");
        }
    }
}
