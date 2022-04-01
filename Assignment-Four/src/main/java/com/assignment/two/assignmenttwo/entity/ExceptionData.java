package com.assignment.two.assignmenttwo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter@Getter@NoArgsConstructor
public class ExceptionData {

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
    @Column(nullable = false,name = "exception_type")
    private String ExceptionType;

    public ExceptionData(String operation, User user,String exceptionType) {
        this.DateTime=LocalDateTime.now();
        this.Operation=operation;
        this.Principle=user;
        this.ExceptionType=exceptionType;

    }
}
