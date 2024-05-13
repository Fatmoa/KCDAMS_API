package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drugs")

public class Drugs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugCode;
    private String drugName;
}
