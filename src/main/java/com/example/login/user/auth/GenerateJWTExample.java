package com.example.login.user.auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class GenerateJWTExample {
    private static String username;
    private static String userrole;

    public static void main(String... args) {
        GenerateJWTExample.username = username;
        GenerateJWTExample.userrole = userrole;
        String secret = "123@abc";
        Algorithm algorithm = Algorithm.HMAC512(secret);

        String generatedToken = JWT.create()
                .withIssuer("Simple Solution")
                .withClaim("username", username)
                .withClaim("role", userrole)
                .sign(algorithm);

        System.out.println(generatedToken);
    }
}