package com.example.employee.service.service.seviceimpl;

import com.example.employee.service.VO.Faculty;
import com.example.employee.service.VO.ResponseTemplateVo;
import com.example.employee.service.entity.Employee;
import com.example.employee.service.repository.EmployeeRepository;
import com.example.employee.service.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Employee getEmployee(Long id) {
        log.info("Inside getEmployee of EmployeeServiceImpl");
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Inside getAllEmployees of EmployeeServiceImpl");
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveEmployee of EmployeeServiceImpl");
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        log.info("Inside updateEmployee of EmployeeServiceImpl");
        employee.setEmployeeId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Inside deleteEmployee of EmployeeServiceImpl");
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseTemplateVo getEmployeeWithFaculty(Long id) {
        log.info("Inside getEmployeeWithFaculty of EmployeeServiceImpl");
        ResponseTemplateVo vo=new ResponseTemplateVo();
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Record not found exception"));

        Faculty faculty=restTemplate.getForObject( "http://FACULTY-SERVICE/faculties/"+employee.getFacultyId(),Faculty.class);
        vo.setEmployee(employee);
        vo.setFaculty(faculty);

        return vo;
    }
}
