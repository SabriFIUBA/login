package com.example.login.user.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JWTService {

    //private long DEFAULT_EXPIRE_IN_SECONDS = 60;

    private String secret = "123@abc";

    private Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateJWTToken(String username, String role) {
        //long now = new Date().getTime();
        //long expireTime = now + (DEFAULT_EXPIRE_IN_SECONDS * 1000);
        //Date expireDate = new Date(expireTime);

        String jwtToken = JWT.create()
                .withIssuer("Simple Solution")
                .withClaim("username", username)
                .withClaim("role", role)
                //.withExpiresAt(expireDate)
                .sign(algorithm);

        return jwtToken;
    }

    public boolean verifyJWTToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Simple Solution")
                    //.acceptExpiresAt(DEFAULT_EXPIRE_IN_SECONDS)
                    .build();

            verifier.verify(token);
            return true;
        } catch (JWTVerificationException ex) {
            return false;
        }
    }

    public String getClaimFromToken(String token, String claimKey) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims().get(claimKey).toString();
    }
}
