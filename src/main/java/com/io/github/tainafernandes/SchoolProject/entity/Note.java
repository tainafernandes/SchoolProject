package com.io.github.tainafernandes.SchoolProject.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double note;
    private Boolean approved;

    @OneToMany(mappedBy = "note")
    private List<Student> student;

    @OneToMany(mappedBy = "note")
    private List<Matter> matter;
}
