package com.example.learningplatform.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}
