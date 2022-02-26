package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Login {

    private String email;
    private String password;

    public static Login getUserCredentials(User user){
        return new Login(user.getEmail(),user.getPassword());
    }

    public static Login getUserCredentials(Map<String,String> user){
        return new Login(user.get("email"),user.get("password"));
    }

}
