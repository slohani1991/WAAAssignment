package com.assignment.two.assignmenttwo.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter@Setter@ToString
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String previousRefreshToken;
    private String refreshToken;

    public Token(String previousRefreshToken, String refreshToken) {
        this.previousRefreshToken = previousRefreshToken;
        this.refreshToken = refreshToken;
    }
}
