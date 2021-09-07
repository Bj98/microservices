package com.example.employee.service.VO;

import com.example.employee.service.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private Employee employee;
    private Faculty faculty;
}

