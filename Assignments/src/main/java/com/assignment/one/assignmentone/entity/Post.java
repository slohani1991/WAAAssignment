package com.assignment.one.assignmentone.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {

    private long id;
    private String title;
    private String content;
    private String author;

}
