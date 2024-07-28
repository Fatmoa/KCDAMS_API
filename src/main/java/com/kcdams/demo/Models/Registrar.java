package com.kcdams.demo.Models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Registrar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regId;
    private String regisName;
    private  String regisMname;
    private  String regisLname;
    private String resiGender;
    private String regisEmail;
    private String regisNumb;
    private String emplNum;

    @ManyToOne
    @JoinColumn(name= "userId", referencedColumnName = "userId")
    private Users user_data;
}
