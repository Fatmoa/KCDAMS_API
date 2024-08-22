package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Psychologist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pyId;
    private String drugDuration;
    private String drugDay;
    private String drug;
    private String reasUse;
    private String tStop;
    private String rStop;
    private String fHistory;
    private String crAffair;
    private List<String> symptoms;
    private String sPlan;
    private String comm;

//    @ManyToOne
//    @JoinColumn(name= "drugCode", referencedColumnName = "drugCode")
//    private Drugs drugs;
}
