package com.todo.app.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class JwtService {


    // Secret key used to sign and verify JWT token
    // In production keep this in application.properties/environment variable
    private final String SECRET_KEY =
            "myverylongsecretkeymyverylongsecretkey12345";


    private Key getSigningKey(){

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );

    }




    // Generate JWT token using user's email
    public String generateToken(String email){


        return Jwts.builder()

                // Data stored inside token
                .setSubject(email)

                // Token creation time
                .setIssuedAt(new Date())


                // Token expiry (24 hours)
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        +
                                        1000 * 60 * 60 * 24
                        )
                )


                // Sign token using secret key
                .signWith(
                        getSigningKey(),
                        SignatureAlgorithm.HS256
                )


                // Convert token into String
                .compact();

    }


    public String extractUsername(String token){

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }



    public boolean isValid(
            String token,
            UserDetails userDetails
    ){

        String username = extractUsername(token);

        return username.equals(
                userDetails.getUsername()
        );

    }

}