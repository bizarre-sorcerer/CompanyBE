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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentsRepository departmentsRepository;
    private final QualificationRepository qualificationRepository;
    private final PositionRepository positionRepository;
    private final EmployeesMapper employeesMapper;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            DepartmentsRepository departmentsRepository,
            QualificationRepository qualificationRepository,
            PositionRepository positionRepository,
            EmployeesMapper employeesMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentsRepository = departmentsRepository;
        this.qualificationRepository = qualificationRepository;
        this.positionRepository = positionRepository;
        this.employeesMapper = employeesMapper;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return employeesMapper.toDTO(employee);
        } else {
            return null;
        }
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

        Department department = departmentsRepository.findById(employeeDTO.getDepartment().getId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found by this id"));

        Qualification qualification = qualificationRepository.findById(employeeDTO.getQualification().getId())
                .orElseThrow(() -> new EntityNotFoundException("Qualification not found by this id "));

        Position position = positionRepository.findById(employeeDTO.getPosition().getId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found by this id"));

        employee.setDepartment(department);
        employee.setQualification(qualification);
        employee.setPosition(position);

        Employee saveEmployee = employeeRepository.save(employee);
        return employeesMapper.toDTO(saveEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employeeDTO) {
        employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: "+ employeeId));
        Employee employee = employeesMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeesMapper.toDTO(savedEmployee);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
