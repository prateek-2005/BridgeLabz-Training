package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDAO {

	@Override
	public int insertPatient(Patient patient) {
		String sql = """
				INSERT INTO patients
				(first_name,last_name,date_of_birth,gender,phone_number,email,is_active)
				VALUES(?,?,?,?,?,?,?)
				""";
		try (Connection conn = HikariConnectionPool.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setDate(3, patient.getDateOfBirth());
			ps.setString(4, patient.getGender());
			ps.setString(5, patient.getPhoneNumber());
			ps.setString(6, patient.getEmail());
			ps.setBoolean(7, patient.isActive());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		String sql = """
				UPDATE patients
				SET first_name=?,
				last_name=?
				date_of_birth=?,
				gender=?,
				phone_number=?,
				email=?,
				is_active=?
				WHERE patient_id=?
				""";
		try (Connection conn = HikariConnectionPool.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setDate(3, patient.getDateOfBirth());
			ps.setString(4, patient.getGender());
			ps.setString(5, patient.getPhoneNumber());
			ps.setString(6, patient.getEmail());
			ps.setBoolean(7, patient.isActive());
			ps.setInt(8, patient.getPatientId());
			return ps.executeUpdate() > 0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePatient(int patientId) {
		String sql = "DELETE FROM patients WHERE patient_id=?";
		try (Connection conn = HikariConnectionPool.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			return ps.executeUpdate() > 0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Patient getPatientById(int patientId) {
		String sql = "SELECT * FROM patients WHERE patient_id=?";
		try (Connection conn = HikariConnectionPool.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Patient patient = new Patient();
				patient.setPatientId(rs.getInt("patient_id"));
				patient.setFirstName(rs.getString("first_name"));
				patient.setLastName(rs.getString("last_name"));
				patient.setDateOfBirth(rs.getDate("date_of_birth"));
				patient.setGender(rs.getString("gender"));
				patient.setPhoneNumber(rs.getString("phone_number"));
				patient.setEmail(rs.getString("email"));
				patient.setActive(rs.getBoolean("is_active"));
				patient.setRegisteredOn(rs.getTimestamp("registered_on"));
				return patient;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	 @Override
	    public List<Patient> getAllPatients() {

	        List<Patient> list=new ArrayList<>();

	        String sql="SELECT * FROM patients";

	        try(Connection conn=HikariConnectionPool.getConnection();
	            PreparedStatement ps=conn.prepareStatement(sql);
	            ResultSet rs=ps.executeQuery()){

	            while(rs.next()){

	                Patient patient=new Patient();

	                patient.setPatientId(rs.getInt("patient_id"));
	                patient.setFirstName(rs.getString("first_name"));
	                patient.setLastName(rs.getString("last_name"));
	                patient.setDateOfBirth(rs.getDate("date_of_birth"));
	                patient.setGender(rs.getString("gender"));
	                patient.setPhoneNumber(rs.getString("phone_number"));
	                patient.setEmail(rs.getString("email"));
	                patient.setActive(rs.getBoolean("is_active"));
	                patient.setRegisteredOn(rs.getTimestamp("registered_on"));

	                list.add(patient);
	            }

	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }

	        return list;
	    }
}
