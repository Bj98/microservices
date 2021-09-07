package com.example.faculty.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long facultyId;

    private String facultyName;

}
