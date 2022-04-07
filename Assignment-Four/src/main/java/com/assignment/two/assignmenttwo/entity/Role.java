package com.assignment.two.assignmenttwo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "role_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleID;
    @Column(nullable = false,name = "role")
    private String role;

}
