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
    private boolean Methadone;
    private boolean Heroin;
    private boolean Valium;
    private boolean Cocaine;
    private boolean Mirungi;
    private boolean Bangi;
    private String comment;
    private int meth;
    private int hero;
    private int val;
    private int coc;
    private int mir;
    private int bang;
    private int methd;
    private int heroi;
    private int vali;
    private int coca;
    private int mirung;
    private int mirg;
    private String press;
    private String bp;
    private String weight;
    private String height;
    private String pulse;
    private String pr;




}
