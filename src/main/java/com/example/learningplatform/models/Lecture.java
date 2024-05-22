package com.example.learningplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    @Id
    @SequenceGenerator(
            name = "lecture_sequence",
            sequenceName = "lecture_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lecture_sequence"
    )
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "section_id"
    )
    private Section section;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resources resources;
}
