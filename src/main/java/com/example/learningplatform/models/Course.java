package com.example.learningplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Integer id;
    private String title;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "auhtors_courses",
            joinColumns = {
                    @JoinColumn(name="course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authorList;

    @OneToMany(mappedBy = "course")
    private List<Section> sectionList;
}
