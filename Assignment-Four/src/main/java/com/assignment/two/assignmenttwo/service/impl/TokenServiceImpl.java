package com.assignment.two.assignmenttwo.service.impl;

import com.assignment.two.assignmenttwo.entity.Token;
import com.assignment.two.assignmenttwo.repo.TokenRepository;
import com.assignment.two.assignmenttwo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void save(Token token) {
        tokenRepository.save(token);
    }

    @Override
    public boolean isRefreshTokenExist(String refreshToken) {
        return tokenRepository.existsTokenByRefreshToken(refreshToken);
    }

    @Override
    public void deleteRefreshToken(String refreshToken) {
       Token token = tokenRepository.findByPreviousRefreshToken(refreshToken);
       if (token!=null){
           tokenRepository.delete(token);
       }
    }

    @Override
    public void updateRefreshToken(String refreshToken, String newRefreshToken) {
        Token token = tokenRepository.findByRefreshToken(refreshToken);
        token.setPreviousRefreshToken(token.getRefreshToken());
        token.setRefreshToken(newRefreshToken);
        tokenRepository.save(token);
    }
}
