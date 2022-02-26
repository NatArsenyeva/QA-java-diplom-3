package com.model;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String email;
    private String password;
    private String name;

    public static Faker faker = new Faker();

    public static User getRandomUser(){
        return new User(faker.internet().emailAddress(),faker.internet().password(),faker.name().username());
    }

    public static User getRandomUserWithPassword(String password){
        return new User(faker.internet().emailAddress(),password,faker.name().username());
    }

}
