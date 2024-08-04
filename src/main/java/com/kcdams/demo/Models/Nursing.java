package com.kcdams.demo.Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity


public class Nursing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int NusId;
    private String nusName;
    private  String nusMname;
    private  String nusLname;
    private String nusGender;
    private String nusEmail;
//    @ManyToOne
//    @JoinColumn(name="roleId", referencedColumnName = "roleId")
//    private Role roles;
    private String nusPnumb;
    private String nusemplNum;

    @ManyToOne
    @JoinColumn(name= "userId", referencedColumnName = "userId")
    private Users user_data;

}
