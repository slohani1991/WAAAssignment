package com.assignment.two.assignmenttwo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Logger {

    @Id
    @Column(nullable = false,name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long TransactionID;
    @Column(nullable = false)
    private LocalDateTime DateTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User Principle;
    @Column(nullable = false)
    private String Operation;


    public Logger(String operation, User user) {
        this.DateTime= LocalDateTime.now();
        this.Operation=operation;
        this.Principle=user;
    }
}
