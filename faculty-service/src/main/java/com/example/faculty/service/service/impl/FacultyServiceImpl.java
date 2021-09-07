package com.example.faculty.service.service.impl;

import com.example.faculty.service.entity.Faculty;
import com.example.faculty.service.service.FacultyService;
import com.example.faculty.service.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty getFaculty(Long id) {
        log.info("Inside getFaculty of  FacultyServiceImpl");
        return facultyRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found"));
    }

    @Override
    public List<Faculty> getAllFaculties() {
        log.info("Inside getAllFaculties of  FacultyServiceImpl");
        return facultyRepository.findAll();
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        log.info("Inside updateFaculty of  FacultyServiceImpl");
        faculty.setFacultyId(id);
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        log.info("Inside deleteFaculty of  FacultyServiceImpl");
         facultyRepository.deleteById(id);
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        log.info("Inside saveFaculty of  FacultyServiceImpl");
        return facultyRepository.save(faculty);
    }
}
