package com.assignment.two.assignmenttwo.service;


import com.assignment.two.assignmenttwo.entity.Token;

public interface TokenService {

    void save(Token token);

    boolean isRefreshTokenExist(String refreshToken);

    void deleteRefreshToken(String refreshToken);

    void updateRefreshToken(String refreshToken, String newRefreshToken);
}
