package com.clinic.dao;

import com.clinic.dto.Patient;
import java.util.*;
public interface PatientDAO {
	
	int insertPatient(Patient patient);
	boolean updatePatient(Patient patient);
	boolean deletePatient(int patientId);
	Patient getPatientById(int patientId);
	List<Patient> getAllPatients();
}
