package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
//@Table(name = "reception")

public class Reception {

    @Id
    private String matCode;
    private String patFName;
    private String patMName;
    private String patLName;
    private String gender;
    private String mar_status;
    private String employment;
    private String education;
    private int no_children;
    private String reg;
    private Date dob;
    private String phoneNumber;
    private String Nida;
    private String ngoName;
    private String cowName;
    private String CowPhone;
    private String KinName;
    private String kinPhoneNumber;
    private String kinRelation;
    private String address;

    @ManyToOne
    @JoinColumn(name = "districtCode",referencedColumnName = "districtCode")
    private District districtData;
}
