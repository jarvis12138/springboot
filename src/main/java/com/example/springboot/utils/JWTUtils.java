package com.example.springboot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String SIGN = "!*#(@)@8932";

    public static String createJWT(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGN));

        return token;
    }

    public static boolean verifyJWT(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
