package com.kcdams.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int obId;
    private String usag;
    private List<String> drugType;
    private List<String> deseas;
    private String lastDrug;
    private String lastUsg;
    private String TBtreat;
    private String comment;
    private String niddle;
    private String Pl_niddle;
    private String venous;
    private String Pl_venous;
    private String phlebitis;
    private String Pl_phlebitis;
    private String press;
    private String bp;
    private String partner;
    private String weight;
    private String height;
    private String pulse;
    private String pr;

}
