package com.fooddelivery.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String fullName;
    private String address;
    private String city;
    private String password;
    private String email;
}
