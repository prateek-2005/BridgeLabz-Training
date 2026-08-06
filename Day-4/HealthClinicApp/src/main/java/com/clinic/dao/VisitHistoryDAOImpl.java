package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int insertVisitHistory(VisitHistory visitHistory) {

        String sql = """
                INSERT INTO visit_history
                (appointment_id, diagnosis, prescription, visit_notes)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, visitHistory.getAppointmentId());
            ps.setString(2, visitHistory.getDiagnosis());
            ps.setString(3, visitHistory.getPrescription());
            ps.setString(4, visitHistory.getVisitNotes());

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
    public boolean updateVisitHistory(VisitHistory visitHistory) {

        String sql = """
                UPDATE visit_history
                SET appointment_id = ?,
                    diagnosis = ?,
                    prescription = ?,
                    visit_notes = ?
                WHERE visit_id = ?
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, visitHistory.getAppointmentId());
            ps.setString(2, visitHistory.getDiagnosis());
            ps.setString(3, visitHistory.getPrescription());
            ps.setString(4, visitHistory.getVisitNotes());
            ps.setInt(5, visitHistory.getVisitId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteVisitHistory(int visitId) {

        String sql = "DELETE FROM visit_history WHERE visit_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, visitId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public VisitHistory getVisitHistoryById(int visitId) {

        String sql = "SELECT * FROM visit_history WHERE visit_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, visitId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapVisitHistory(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public VisitHistory getVisitHistoryByAppointmentId(int appointmentId) {

        String sql = "SELECT * FROM visit_history WHERE appointment_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapVisitHistory(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VisitHistory> getAllVisitHistories() {

        List<VisitHistory> histories = new ArrayList<>();

        String sql = "SELECT * FROM visit_history ORDER BY visit_id";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                histories.add(mapVisitHistory(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return histories;
    }

    private VisitHistory mapVisitHistory(ResultSet rs) throws SQLException {

        VisitHistory visitHistory = new VisitHistory();

        visitHistory.setVisitId(rs.getInt("visit_id"));
        visitHistory.setAppointmentId(rs.getInt("appointment_id"));
        visitHistory.setDiagnosis(rs.getString("diagnosis"));
        visitHistory.setPrescription(rs.getString("prescription"));
        visitHistory.setVisitNotes(rs.getString("visit_notes"));

        return visitHistory;
    }
}