package com.kcdams.demo.Models;


import com.kcdams.demo.Models.Region;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "district")

public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int districtCode;
    @ManyToOne
    @JoinColumn(name = "regionCode", referencedColumnName = "regionCode")
    private Region region;
    private String districtName;
    private int districtStatus;
}
