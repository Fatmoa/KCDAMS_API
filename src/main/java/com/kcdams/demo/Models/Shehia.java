package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shehia")

public class Shehia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shehiaCode;
    @ManyToOne
    @JoinColumn(name = "districtCode", referencedColumnName = "districtCode")
    private District district;
    private String shehiaName;
    private int shehiaStatus;
}
