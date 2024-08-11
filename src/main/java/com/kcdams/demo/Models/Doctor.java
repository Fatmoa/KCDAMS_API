package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drId;
    private String drName;
    private String drMname;
    private String drLname;
    private String drGender;
    private String drEmail;
    private String drNumb;
    private String drEmplNum;

    @ManyToOne
    @JoinColumn(name= "userId", referencedColumnName = "userId")
    private Users user_data;
}
