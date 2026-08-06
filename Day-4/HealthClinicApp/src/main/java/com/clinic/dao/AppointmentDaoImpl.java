package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements AppointmentDAO {

    @Override
    public int insertAppointment(Appointment appointment) {

        String sql = """
                INSERT INTO appointments
                (patient_id, doctor_id, appointment_date, status)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {

        String sql = """
                UPDATE appointments
                SET patient_id=?,
                    doctor_id=?,
                    appointment_date=?,
                    status=?
                WHERE appointment_id=?
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getAppointmentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteAppointment(int appointmentId) {

        String sql = "DELETE FROM appointments WHERE appointment_id=?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {

        String sql = "SELECT * FROM appointments WHERE appointment_id=?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapAppointment(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments ORDER BY appointment_date";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appointments.add(mapAppointment(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(int patientId) {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments WHERE patient_id=? ORDER BY appointment_date";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appointments.add(mapAppointment(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments WHERE doctor_id=? ORDER BY appointment_date";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appointments.add(mapAppointment(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public boolean updateAppointmentStatus(int appointmentId, String status) {

        String sql = "UPDATE appointments SET status=? WHERE appointment_id=?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Appointment mapAppointment(ResultSet rs) throws SQLException {

        Appointment appointment = new Appointment();

        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
        appointment.setStatus(rs.getString("status"));

        return appointment;
    }
}