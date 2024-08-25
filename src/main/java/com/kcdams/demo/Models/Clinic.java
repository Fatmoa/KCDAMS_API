package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity

public class Clinic {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int clID;
    private Date startDate;
    private Date endingDate;
    private List<Date> visitDate;
    private String dose;
    @ManyToOne
    @JoinColumn(name="matCode" ,referencedColumnName = "matCode")
    private Reception patientData;

}
