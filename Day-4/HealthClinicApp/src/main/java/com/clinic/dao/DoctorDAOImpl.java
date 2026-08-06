package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int insertDoctor(Doctor doctor) {

        String sql = """
                INSERT INTO doctors
                (first_name,last_name,phone_number,email,is_active)
                VALUES(?,?,?,?,?)
                """;

        try (Connection conn = HikariConnectionPool.getConnection()) {
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getPhoneNumber());
            ps.setString(4, doctor.getEmail());
            ps.setBoolean(5, doctor.isActive());

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
    public boolean updateDoctor(Doctor doctor) {

        String sql = """
                UPDATE doctors
                SET first_name=?,
                    last_name=?,
                    phone_number=?,
                    email=?,
                    is_active=?
                WHERE doctor_id=?
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getPhoneNumber());
            ps.setString(4, doctor.getEmail());
            ps.setBoolean(5, doctor.isActive());
            ps.setInt(6, doctor.getDoctorId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteDoctor(int doctorId) {

        String sql = "DELETE FROM doctors WHERE doctor_id=?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {

        String sql = "SELECT * FROM doctors WHERE doctor_id=?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
                doctor.setActive(rs.getBoolean("is_active"));

                return doctor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        String sql = "SELECT * FROM doctors ORDER BY doctor_id";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
                doctor.setActive(rs.getBoolean("is_active"));

                doctors.add(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

}