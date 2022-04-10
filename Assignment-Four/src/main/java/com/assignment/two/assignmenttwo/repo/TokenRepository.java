package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {

    boolean existsTokenByRefreshToken(String refreshToken);

    void deleteByPreviousRefreshToken(String refreshToken);

    Token findByRefreshToken(String refreshToken);

    Token findByPreviousRefreshToken(String refreshToken);

}
