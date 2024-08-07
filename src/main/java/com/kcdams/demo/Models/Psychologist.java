package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Psychologist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pyId;
    private String pyName;
    private String pyMname;
    private String pyLname;
    private String pyGender;
    private String pyEmail;
    private String pyNumb;
    private String pyEmplNum;

    @ManyToOne
    @JoinColumn(name= "userId", referencedColumnName = "userId")
    private Users user_data;
}
