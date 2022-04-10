package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.exception.InvalidUserException;
import com.assignment.two.assignmenttwo.model.LoginRequest;
import com.assignment.two.assignmenttwo.model.LoginResponse;
import com.assignment.two.assignmenttwo.model.RefreshTokenRequest;
import com.assignment.two.assignmenttwo.security.JWT.JwtHelper;
import com.assignment.two.assignmenttwo.service.AuthService;

import com.assignment.two.assignmenttwo.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final TokenService tokenService;

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

                final String accessToken = jwtHelper.generateToken(userDetails);
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
            boolean isAccessTokenExpired = jwtHelper.isTokenExpired(refreshTokenRequest.getAccessToken());
            isAccessTokenExpired = false;
            if (isAccessTokenExpired) {
                if (!tokenService.isRefreshTokenExist(refreshTokenRequest.getRefreshToken())) {
                    tokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
                    throw new InvalidUserException("Invalid Refresh Token");
                }
                String newRefreshToken = jwtHelper.generateNewRefreshToken(refreshTokenRequest.getAccessToken());
                tokenService.updateRefreshToken(refreshTokenRequest.getRefreshToken(), newRefreshToken);
                System.out.println("ACCESS TOKEN IS EXPIRED");
                final String newAccessToken = jwtHelper.doGenerateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
                new LoginResponse(newAccessToken, newRefreshToken);
            } else {
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            }
        }
        return new LoginResponse(refreshTokenRequest.getAccessToken(),refreshTokenRequest.getRefreshToken());
    }
}
