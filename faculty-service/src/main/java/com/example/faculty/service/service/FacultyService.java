package com.example.faculty.service.service;

import com.example.faculty.service.entity.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty getFaculty(Long id);

    List<Faculty> getAllFaculties();

    Faculty updateFaculty(Long id, Faculty faculty);

    void deleteFaculty(Long id);

    Faculty saveFaculty(Faculty faculty);
}
