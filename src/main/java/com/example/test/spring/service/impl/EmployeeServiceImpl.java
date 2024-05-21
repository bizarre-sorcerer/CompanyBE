package com.example.test.spring.service.impl;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Employee;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.repositories.EmployeeRepository;
import com.example.test.spring.service.EmployeeService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeesMapper employeesMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeesMapper employeesMapper) {
        this.employeeRepository = employeeRepository;
        this.employeesMapper = employeesMapper;
    }

    @Override
    public EmployeeDTO getEmployeeById(UUID employeeId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return employeesMapper.toDto(employee);
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    };

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeesMapper.toEntity(employeeDTO);
        Employee saveEmployee = employeeRepository.save(employee);
        return employeesMapper.toDto(saveEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(UUID employeeId, EmployeeDTO employeeDTO){
//        UUID employeeId = employeeDTO.getId();
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employeesMapper.toDto(employee);

            employeeRepository.save(employee);
            return employeesMapper.toDto(employee);
        }
        return employeeDTO;
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(UUID employeeId){
        employeeRepository.deleteById(employeeId);
    }
}
