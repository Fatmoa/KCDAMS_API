package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="region")

public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regCode;
    private String regName;
    private int regStatus;
}
