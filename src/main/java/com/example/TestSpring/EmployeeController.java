package com.example.TestSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    record NewEmployeeRequest(
            String firstName,
            String lastName,
            String email,
            String department,
            String skillLevel,
            String role,
            String experience,
            String salary
    ) { }

    @PostMapping("/employees")
    public void createEmployee(NewEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.firstName);
        employee.setLastName(request.lastName);
        employee.setEmail(request.email);
        employee.setDepartment(request.department);
        employee.setSkillLevel(request.skillLevel);
        employee.setRole(request.role);
        employee.setExperience(request.experience);
        employee.setSalary(request.salary);
        employeeRepository.save(employee);
    }
}
