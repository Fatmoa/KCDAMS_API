package com.kcdams.demo.Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "kins")

public class Kin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kinCode;
    private String firstName;
    private String lastName;
    private String relation;
    private  int phNumber;
}
