package com.example.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/employeeServiceFallBack")
    public String employeeServiceFallBackMethod(){
        return "Employee Service is taking longer than expected."+
                " Please try again later";
    }
    @GetMapping("/facultyServiceFallBack")
    public String facultyServiceFallBackMethod(){
        return "Faculty Service is taking longer than expected."+
                " Please try again later";
    }
}
