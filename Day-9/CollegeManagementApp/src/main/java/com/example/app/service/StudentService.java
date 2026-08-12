package com.example.app.service;

import com.example.app.entity.Student;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Integer id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
	}

	public Student updateStudent(Integer id, Student student) {
		Student existing = getStudentById(id);
		existing.setRollNumber(student.getRollNumber());
		existing.setFirstName(student.getFirstName());
		existing.setLastName(student.getLastName());
		existing.setGender(student.getGender());
		existing.setEmail(student.getEmail());
		existing.setAddress(student.getAddress());
		existing.setCity(student.getCity());
		existing.setState(student.getState());
		existing.setCourse(student.getCourse());
		existing.setDepartment(student.getDepartment());
		existing.setAdmissionYear(student.getAdmissionYear());

		return studentRepository.save(existing);
	}

	public void deleteStudent(Integer id) {
		Student student = getStudentById(id);
		studentRepository.delete(student);
	}
}