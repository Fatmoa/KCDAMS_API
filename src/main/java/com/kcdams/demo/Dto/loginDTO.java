package com.kcdams.demo.Dto;


import com.kcdams.demo.Models.Role;
import lombok.Data;

@Data
public class loginDTO {
    private  String username;
    private  String password;
    private Role roleId;
    private  String userStatus;
}
