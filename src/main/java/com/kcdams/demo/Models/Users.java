package com.kcdams.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private  String username;
    private  String password;
    @ManyToOne
    @JoinColumn(name = "roleId",referencedColumnName = "roleId")
    private Role roleId;
    private  String userStatus;
}
