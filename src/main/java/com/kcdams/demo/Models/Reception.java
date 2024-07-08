package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
//@Table(name = "reception")

public class Reception {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int matCode;
    private String matCode;
    private String patFName;
    private String patSName;
    private String patLName;
    private Date DOB;
    private String phoneNumber;
    private String Nida;
    private String ngoName;
    private String cowName;
    private String CowPhone;
    private String KinName;
    private String kinRelationship;
    private String kinNumber;
}
