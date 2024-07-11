package com.example.test.spring.service.impl;

import com.example.test.spring.models.dtos.LoginDTO;
import com.example.test.spring.models.dtos.registerDTO;
import com.example.test.spring.models.entities.Employee;
import com.example.test.spring.models.entities.Role;
import com.example.test.spring.repositories.EmployeeRepository;
import com.example.test.spring.repositories.RoleRepository;
import com.example.test.spring.configs.security.JwtGenerator;
import com.example.test.spring.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    EmployeeRepository employeeRepository;
    RoleRepository roleRepository;
    JwtGenerator jwtGenerator;
    AuthenticationManager authenticationManager;
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> signUp(registerDTO registerDTO) {
        Employee employee = new Employee();
        employee.setFirstName(registerDTO.getFirstName());
        employee.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role roles = roleRepository.findByName("USER").
                orElseThrow(() -> new RuntimeException("Role not found"));
        employee.setRoles(Collections.singletonList(roles));
        employeeRepository.save(employee);

        return new ResponseEntity<>("Sign up successful", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> signIn(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(), loginDTO.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
