package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zoneCode;
    private String zoneName;
    private int zoneStatus;
}
