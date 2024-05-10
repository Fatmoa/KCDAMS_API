package com.kcdams.demo.Models;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="region")

public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionCode;
    @ManyToOne
    @JoinColumn(name = "zoneCode", referencedColumnName = "zoneCode")
    private Zone zone;
    private String regionName;
    private int regionStatus;
}
