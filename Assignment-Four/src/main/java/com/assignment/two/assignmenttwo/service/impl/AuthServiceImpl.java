package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.model.LoginRequest;
import com.assignment.two.assignmenttwo.model.LoginResponse;
import com.assignment.two.assignmenttwo.model.RefreshTokenRequest;
import com.assignment.two.assignmenttwo.security.JWT.JwtHelper;
import com.assignment.two.assignmenttwo.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
            if(result.isAuthenticated()){
                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(loginRequest.getEmail());

                final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
                final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
                var loginResponse = new LoginResponse(accessToken, refreshToken);
                return loginResponse;
            }

        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        return null;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}
