package com.example.login;

import com.example.login.user.auth.GenerateJWTExample;
import com.example.login.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.login.user.auth.JWTService;
@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
        System.out.println("corriendo");
        //GenerateJWTExample.main("TestUser", "User");
        //@Autowired
        JWTService jwtService = new JWTService();

        String token = jwtService.generateJWTToken("user1","User");
        System.out.println(token);
        System.out.println(jwtService.verifyJWTToken(token));
    }

}
