package com.vietsoftware.demo_ai.service.impl;

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
            throw new RuntimeException("Error fetching employee", ex);
        }
    }

    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity updateEmployee(Integer id, EmployeeRequest request) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        try {
            EmployeeEntity employee = EmployeeMapper.INSTANCE.toEntity(request);
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
