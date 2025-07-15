package com.vietsoftware.demo_ai.service.impl;

import com.vietsoftware.demo_ai.constants.AppConstants;
import com.vietsoftware.demo_ai.mapper.EmployeeMapper;
import com.vietsoftware.demo_ai.model.EmployeeEntity;
import com.vietsoftware.demo_ai.repository.EmployeeRepository;
import com.vietsoftware.demo_ai.request.EmployeeRequest;
import com.vietsoftware.demo_ai.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer id) {
        try {
            return employeeRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            throw new RuntimeException(AppConstants.ERROR_FETCHING_EMPLOYEE, ex);
        }
    }

    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        // Validate employee data before saving
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new RuntimeException(AppConstants.EMPLOYEE_NAME_EMPTY);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity updateEmployee(Integer id, EmployeeRequest request) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException(AppConstants.EMPLOYEE_NOT_FOUND + id);
        }
        try {
            EmployeeEntity employee = EmployeeMapper.INSTANCE.toEntity(request);
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(AppConstants.ERROR_UPDATING_EMPLOYEE + e.getMessage(), e);
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
