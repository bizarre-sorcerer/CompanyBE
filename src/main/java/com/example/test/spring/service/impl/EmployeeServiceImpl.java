package com.example.test.spring.service.impl;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Department;
import com.example.test.spring.entities.Employee;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.repositories.DepartmentsRepository;
import com.example.test.spring.repositories.EmployeeRepository;
import com.example.test.spring.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentsRepository departmentsRepository;
    private final EmployeesMapper employeesMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeesMapper employeesMapper, DepartmentsRepository departmentsRepository) {
        this.employeeRepository = employeeRepository;
        this.employeesMapper = employeesMapper;
        this.departmentsRepository = departmentsRepository;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return employeesMapper.toDTO(employee);
        } else {
            return null;
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employeesMapper::toDTO)
                .collect(Collectors.toList());
    };

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeesMapper.toEntity(employeeDTO);

        Department department = departmentsRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        // Set the fetched Department entity in the Employee entity
        employee.setDepartmentId(department);

        Employee saveEmployee = employeeRepository.save(employee);
        return employeesMapper.toDTO(saveEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employeeDTO){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employeesMapper.toDTO(employee);

            employeeRepository.save(employee);
            return employeesMapper.toDTO(employee);
        }
        return employeeDTO;
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Integer employeeId){
        employeeRepository.deleteById(employeeId);
    }
}
