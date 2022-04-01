package com.assignment.two.assignmenttwo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="id_post")
    private Post post;
}
