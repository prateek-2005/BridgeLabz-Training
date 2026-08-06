package com.clinic.service;

import com.clinic.config.HikariConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentService {

    public boolean completeAppointment(int appointmentId,BigDecimal amount,String diagnosis,String prescription, String visitNotes) {
        Connection conn = null;
        try {
            conn = HikariConnectionPool.getConnection();
            conn.setAutoCommit(false);
            String updateAppointment = """
                    UPDATE appointments
                    SET status = 'Completed'
                    WHERE appointment_id = ?
                    """;
            try (PreparedStatement ps = conn.prepareStatement(updateAppointment)) {
                ps.setInt(1, appointmentId);
                int rows = ps.executeUpdate();
                if (rows == 0) {
                    throw new SQLException("Appointment not found.");
                }
            }
            String billingSql = """
                    INSERT INTO billing
                    (appointment_id, amount, payment_status)
                    VALUES (?, ?, 'Pending')
                    """;
            try (PreparedStatement ps = conn.prepareStatement(billingSql)) {
                ps.setInt(1, appointmentId);
                ps.setBigDecimal(2, amount);
                ps.executeUpdate();
            }
            String visitSql = """
                    INSERT INTO visit_history
                    (appointment_id,
                     diagnosis,
                     prescription,
                     visit_notes)
                    VALUES (?, ?, ?, ?)
                    """;
            try (PreparedStatement ps = conn.prepareStatement(visitSql)) {
                ps.setInt(1, appointmentId);
                ps.setString(2, diagnosis);
                ps.setString(3, prescription);
                ps.setString(4, visitNotes);
                ps.executeUpdate();
            }
            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Transaction Failed : " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transaction Rolled Back Successfully.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean cancelAppointment(int appointmentId) {
        String sql = """
                UPDATE appointments
                SET status='Cancelled'
                WHERE appointment_id=?
                """;
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean markBillAsPaid(int billId) {
        String sql = """
                UPDATE billing
                SET payment_status='Paid'
                WHERE bill_id=?
                """;
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, billId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}