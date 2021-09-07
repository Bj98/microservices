package com.example.faculty.service.controller;

import com.example.faculty.service.entity.Faculty;
import com.example.faculty.service.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Faculty saveFaculty(@RequestBody Faculty faculty){
        log.info("Inside saveFaculty of Faculty Controller");
        return facultyService.saveFaculty(faculty);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Faculty getFaculty(@PathVariable Long id){
        log.info("Inside getFaculty of Faculty Controller");
        return facultyService.getFaculty(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Faculty> getAllFaculties(){
        log.info("Inside getAllFaculties of Faculty Controller");
        return facultyService.getAllFaculties();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Faculty updateFaculty(@PathVariable Long id,@RequestBody Faculty faculty){
        log.info("Inside updateFaculty of Faculty Controller");
        return facultyService.updateFaculty(id,faculty);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFaculty(@PathVariable Long id){
        log.info("Inside deleteFaculty of Faculty Controller");
         facultyService.deleteFaculty(id);
    }

}
