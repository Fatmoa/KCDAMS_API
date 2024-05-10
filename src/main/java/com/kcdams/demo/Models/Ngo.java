package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ngo")

public class Ngo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ngoCode;
    private String ngoName;
    private int ngoStatus;
}
