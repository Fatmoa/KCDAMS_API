package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Psychology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psyId;
    private String psyName;
    private String psyMname;
    private String psyLname;
    private String psyGender;
    private String psyEmail;
    private String psyNumb;
    private String psyEmplNum;

    @ManyToOne
    @JoinColumn(name= "userId", referencedColumnName = "userId")
    private Users user_data;

}
