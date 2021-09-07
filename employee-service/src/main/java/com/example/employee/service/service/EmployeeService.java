package com.example.employee.service.service;

import com.example.employee.service.VO.ResponseTemplateVo;
import com.example.employee.service.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    ResponseTemplateVo getEmployeeWithFaculty(Long id);
}
