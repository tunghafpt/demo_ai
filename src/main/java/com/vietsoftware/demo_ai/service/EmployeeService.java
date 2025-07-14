package com.vietsoftware.demo_ai.service;

import com.vietsoftware.demo_ai.model.EmployeeEntity;
import com.vietsoftware.demo_ai.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(Integer id);
    EmployeeEntity addEmployee(EmployeeEntity employee);
    EmployeeEntity updateEmployee(Integer id, EmployeeRequest employee);
    void deleteEmployee(Integer id);
}

