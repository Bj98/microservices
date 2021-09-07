package com.example.employee.service.controller;

import com.example.employee.service.VO.ResponseTemplateVo;
import com.example.employee.service.entity.Employee;
import com.example.employee.service.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable Long id){
        log.info("Inside getEmployee of EmployeeController");
        return  employeeService.getEmployee(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees(){
        log.info("Inside getAllEmployees of EmployeeController");
        return  employeeService.getAllEmployees();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        log.info("Inside updateEmployee of EmployeeController");
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        log.info("Inside deleteEmployee of EmployeeController");
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/faculty/{id}")
    public ResponseTemplateVo getEmployeeWithFaculty(@PathVariable Long id){
        return employeeService.getEmployeeWithFaculty(id);
    }
}
