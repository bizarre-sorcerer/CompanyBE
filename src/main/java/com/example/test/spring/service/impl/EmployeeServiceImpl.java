package com.example.test.spring.service.impl;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.entities.Department;
import com.example.test.spring.entities.Employee;
import com.example.test.spring.entities.Position;
import com.example.test.spring.entities.Qualification;
import com.example.test.spring.mappers.EmployeesMapper;
import com.example.test.spring.repositories.DepartmentsRepository;
import com.example.test.spring.repositories.EmployeeRepository;
import com.example.test.spring.repositories.PositionRepository;
import com.example.test.spring.repositories.QualificationRepository;
import com.example.test.spring.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentsRepository departmentsRepository;
    private final QualificationRepository qualificationRepository;
    private final PositionRepository positionRepository;
    private final EmployeesMapper employeesMapper;

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return employeesMapper.toDTO(employee);
    }

    @Override
    public Page<EmployeeDTO> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);

        List<EmployeeDTO> allEmployees = employees.stream()
                .map(employeesMapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(allEmployees);
    }

    @Override
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeesMapper.toEntity(employeeDTO);

        Integer departmentId = employeeDTO.getDepartment().getId();
        Integer qualificationId = employeeDTO.getQualification().getId();
        Integer positionId = employeeDTO.getPosition().getId();

        Department department = departmentsRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with this id: " + departmentId));

        Qualification qualification = qualificationRepository.findById(qualificationId)
                .orElseThrow(() -> new EntityNotFoundException("Qualification not found with this id: " + qualificationId));

        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new EntityNotFoundException("Position not found with this id: " + positionId));

        employee.setDepartment(department);
        employee.setQualification(qualification);
        employee.setPosition(position);
        Employee saveEmployee = employeeRepository.save(employee);
        return employeesMapper.toDTO(saveEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Integer id = employeeDTO.getId();
        employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        Employee employee = employeesMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeesMapper.toDTO(savedEmployee);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
