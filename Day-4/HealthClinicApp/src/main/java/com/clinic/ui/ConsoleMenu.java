package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final PatientDAO patientDAO = new PatientDaoImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDaoImpl();

    private final AppointmentService appointmentService =
            new AppointmentService();

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n====================================");
            System.out.println(" HEALTH CLINIC MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Register Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Complete Appointment");
            System.out.println("8. Cancel Appointment");
            System.out.println("9. Exit");

            System.out.print("\nEnter Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> registerPatient();

                case 2 -> viewPatients();

                case 3 -> registerDoctor();

                case 4 -> viewDoctors();

                case 5 -> bookAppointment();

                case 6 -> viewAppointments();

                case 7 -> completeAppointment();

                case 8 -> cancelAppointment();

                case 9 -> {
                    running = false;
                    System.out.println("Thank You.");
                }

                default -> System.out.println("Invalid Choice");
            }

        }

    }

    private void registerPatient() {

        Patient patient = new Patient();

        System.out.print("First Name : ");
        patient.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        patient.setLastName(scanner.nextLine());

        System.out.print("DOB (yyyy-mm-dd): ");
        patient.setDateOfBirth(Date.valueOf(scanner.nextLine()));

        System.out.print("Gender : ");
        patient.setGender(scanner.nextLine());

        System.out.print("Phone : ");
        patient.setPhoneNumber(scanner.nextLine());

        System.out.print("Email : ");
        patient.setEmail(scanner.nextLine());

        patient.setActive(true);

        int id = patientDAO.insertPatient(patient);

        if (id > 0)
            System.out.println("Patient Registered Successfully. ID : " + id);
        else
            System.out.println("Registration Failed.");

    }

    private void viewPatients() {

        List<Patient> patients = patientDAO.getAllPatients();

        if (patients.isEmpty()) {

            System.out.println("No Patient Found.");
            return;

        }

        patients.forEach(System.out::println);

    }

    private void registerDoctor() {

        Doctor doctor = new Doctor();

        System.out.print("First Name : ");
        doctor.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        doctor.setLastName(scanner.nextLine());

        System.out.print("Phone : ");
        doctor.setPhoneNumber(scanner.nextLine());

        System.out.print("Email : ");
        doctor.setEmail(scanner.nextLine());

        doctor.setActive(true);

        int id = doctorDAO.insertDoctor(doctor);

        if (id > 0)
            System.out.println("Doctor Registered. ID : " + id);
        else
            System.out.println("Registration Failed.");

    }


    private void viewDoctors() {

        List<Doctor> doctors = doctorDAO.getAllDoctors();

        if (doctors.isEmpty()) {

            System.out.println("No Doctors Available.");
            return;

        }

        doctors.forEach(System.out::println);

    }

    private void bookAppointment() {

        Appointment appointment = new Appointment();

        System.out.print("Patient ID : ");
        appointment.setPatientId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Doctor ID : ");
        appointment.setDoctorId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Appointment Date (yyyy-mm-dd hh:mm:ss): ");

        appointment.setAppointmentDate(
                Timestamp.valueOf(scanner.nextLine())
        );

        appointment.setStatus("Scheduled");

        int id = appointmentDAO.insertAppointment(appointment);

        if (id > 0)
            System.out.println("Appointment Booked Successfully. ID : " + id);
        else
            System.out.println("Booking Failed.");

    }

    private void viewAppointments() {

        List<Appointment> appointments =
                appointmentDAO.getAllAppointments();

        if (appointments.isEmpty()) {

            System.out.println("No Appointment Found.");
            return;

        }

        appointments.forEach(System.out::println);

    }

    private void completeAppointment() {

        System.out.print("Appointment ID : ");
        int appointmentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Bill Amount : ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        System.out.print("Diagnosis : ");
        String diagnosis = scanner.nextLine();

        System.out.print("Prescription : ");
        String prescription = scanner.nextLine();

        System.out.print("Visit Notes : ");
        String notes = scanner.nextLine();

        boolean completed =
                appointmentService.completeAppointment(
                        appointmentId,
                        amount,
                        diagnosis,
                        prescription,
                        notes
                );

        if (completed)
            System.out.println("Appointment Completed Successfully.");
        else
            System.out.println("Failed.");

    }

    private void cancelAppointment() {

        System.out.print("Appointment ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (appointmentService.cancelAppointment(id))
            System.out.println("Appointment Cancelled.");
        else
            System.out.println("Cancellation Failed.");

    }

}