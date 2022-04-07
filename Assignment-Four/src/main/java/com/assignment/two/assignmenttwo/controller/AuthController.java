package com.assignment.two.assignmenttwo.controller;

import com.assignment.two.assignmenttwo.model.LoginRequest;
import com.assignment.two.assignmenttwo.model.LoginResponse;
import com.assignment.two.assignmenttwo.model.RefreshTokenRequest;
import com.assignment.two.assignmenttwo.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        if(loginResponse!=null) {
            return ResponseEntity.ok().body(loginResponse);
        }return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
