package com.example.app.service;

import com.example.app.entity.Faculty;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.FacultyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Integer id) {
        return facultyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Faculty not found with id: " + id));
    }

    public Faculty updateFaculty(Integer id, Faculty faculty) {
        Faculty existing = getFacultyById(id);
        existing.setFirstName(faculty.getFirstName());
        existing.setLastName(faculty.getLastName());
        existing.setGender(faculty.getGender());
        existing.setEmail(faculty.getEmail());
        existing.setAddress(faculty.getAddress());
        existing.setCity(faculty.getCity());
        existing.setState(faculty.getState());
        existing.setDepartment(faculty.getDepartment());
        existing.setDesignation(faculty.getDesignation());
        existing.setJoiningYear(faculty.getJoiningYear());
        existing.setSalary(faculty.getSalary());

        return facultyRepository.save(existing);
    }

    public void deleteFaculty(Integer id) {
        Faculty faculty = getFacultyById(id);
        facultyRepository.delete(faculty);
    }
}