package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genderData")
public class DataEntity {
    

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int count;
    private String gender;
    private String name;
    private double probability;
}
