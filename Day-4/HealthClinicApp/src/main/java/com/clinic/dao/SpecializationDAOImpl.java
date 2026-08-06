package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {

    @Override
    public int insertSpecialization(Specialization specialization) {

        String sql = """
                INSERT INTO specializations(name, description)
                VALUES(?, ?)
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, specialization.getName());
            ps.setString(2, specialization.getDescription());

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
    public boolean updateSpecialization(Specialization specialization) {

        String sql = """
                UPDATE specializations
                SET name = ?,
                    description = ?
                WHERE specialization_id = ?
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, specialization.getName());
            ps.setString(2, specialization.getDescription());
            ps.setInt(3, specialization.getSpecializationId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteSpecialization(int specializationId) {

        String sql = "DELETE FROM specializations WHERE specialization_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, specializationId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Specialization getSpecializationById(int specializationId) {

        String sql = "SELECT * FROM specializations WHERE specialization_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, specializationId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Specialization specialization = new Specialization();

                specialization.setSpecializationId(rs.getInt("specialization_id"));
                specialization.setName(rs.getString("name"));
                specialization.setDescription(rs.getString("description"));

                return specialization;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Specialization> getAllSpecializations() {

        List<Specialization> specializations = new ArrayList<>();

        String sql = "SELECT * FROM specializations ORDER BY specialization_id";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Specialization specialization = new Specialization();

                specialization.setSpecializationId(rs.getInt("specialization_id"));
                specialization.setName(rs.getString("name"));
                specialization.setDescription(rs.getString("description"));

                specializations.add(specialization);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return specializations;
    }
}