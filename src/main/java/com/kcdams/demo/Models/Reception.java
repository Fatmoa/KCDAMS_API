package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "reception")

public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matCode;
//    private String matCode;
    private String patFName;
    private String patSName;
    private String patLName;
    private Date DOB;
    private int phoneNumber;
    private long Nida;
    private String ngoName;
    private String cowName;
    private int CowPhone;
}
