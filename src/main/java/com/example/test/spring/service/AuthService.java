package com.example.test.spring.service;

import com.example.test.spring.models.dtos.LoginDTO;
import com.example.test.spring.models.dtos.registerDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String> signUp(registerDTO signUpDTO);

    ResponseEntity<String> signIn(LoginDTO signInDTO);
}
