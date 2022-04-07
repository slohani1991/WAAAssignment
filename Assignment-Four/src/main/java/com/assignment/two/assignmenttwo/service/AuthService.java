package com.assignment.two.assignmenttwo.service;

import com.assignment.two.assignmenttwo.model.LoginRequest;
import com.assignment.two.assignmenttwo.model.LoginResponse;
import com.assignment.two.assignmenttwo.model.RefreshTokenRequest;


public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
