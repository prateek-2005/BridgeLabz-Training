package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public int insertBilling(Billing billing) {

        String sql = """
                INSERT INTO billing
                (appointment_id, amount, payment_status)
                VALUES (?, ?, ?)
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, billing.getAppointmentId());
            ps.setBigDecimal(2, billing.getAmount());
            ps.setString(3, billing.getPaymentStatus());

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
    public boolean updateBilling(Billing billing) {

        String sql = """
                UPDATE billing
                SET appointment_id = ?,
                    amount = ?,
                    payment_status = ?
                WHERE bill_id = ?
                """;

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, billing.getAppointmentId());
            ps.setBigDecimal(2, billing.getAmount());
            ps.setString(3, billing.getPaymentStatus());
            ps.setInt(4, billing.getBillId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteBilling(int billId) {

        String sql = "DELETE FROM billing WHERE bill_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, billId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Billing getBillingById(int billId) {

        String sql = "SELECT * FROM billing WHERE bill_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, billId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapBilling(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Billing getBillingByAppointmentId(int appointmentId) {

        String sql = "SELECT * FROM billing WHERE appointment_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapBilling(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Billing> getAllBillings() {

        List<Billing> billings = new ArrayList<>();

        String sql = "SELECT * FROM billing ORDER BY bill_id";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                billings.add(mapBilling(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billings;
    }

    @Override
    public boolean updatePaymentStatus(int billId, String paymentStatus) {

        String sql = "UPDATE billing SET payment_status = ? WHERE bill_id = ?";

        try (Connection conn = HikariConnectionPool.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, paymentStatus);
            ps.setInt(2, billId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Billing mapBilling(ResultSet rs) throws SQLException {

        Billing billing = new Billing();

        billing.setBillId(rs.getInt("bill_id"));
        billing.setAppointmentId(rs.getInt("appointment_id"));
        billing.setAmount(rs.getBigDecimal("amount"));
        billing.setPaymentStatus(rs.getString("payment_status"));
        billing.setBillingDate(rs.getTimestamp("billing_date"));

        return billing;
    }
}