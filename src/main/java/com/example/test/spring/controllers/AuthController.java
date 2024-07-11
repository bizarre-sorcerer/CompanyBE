package com.example.test.spring.controllers;

import com.example.test.spring.models.dtos.LoginDTO;
import com.example.test.spring.models.dtos.registerDTO;
import com.example.test.spring.service.impl.AuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    AuthServiceImpl authService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody registerDTO signUpDTO) {
        return authService.signUp(signUpDTO);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody LoginDTO loginDTO) {
        return authService.signIn(loginDTO);
    }
}
