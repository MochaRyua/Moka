package com.bringup.bringup.service.token;

import com.bringup.bringup.exxeption.ExpiredTokenException;
import com.bringup.bringup.exxeption.InvalidTokenException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${auth.jwt.secret}")
    private String SECURITY_KEY;

    private String generateToken(Integer data, Long expire, String type) {
        long nowMillis = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(nowMillis))
                .setHeaderParam("typ", "JWT")
                .claim("uuid", data)
                .claim("type", type)
                .setExpiration(new Date(nowMillis + expire))
                .signWith(SignatureAlgorithm.HS256, SECURITY_KEY.getBytes());

        return builder.compact();
    }

    @Override
    public String generateAccessToken(Integer data) {
        return generateToken(data, 1000L * 3600 * 2, "access_token");
    }

    @Override
    public String generateRefreshToken(Integer data) {
        return generateToken(data, 1000L * 3600 * 24 * 30, "refresh_token");
    }

    @Override
    public Integer parseToken(String token) {
        String result;
        try {
            Claims body = Jwts.parser().setSigningKey(SECURITY_KEY.getBytes()).parseClaimsJws(token).getBody();
            result = body.get("uuid").toString();
            if (!body.get("type").equals("access_token")) throw new InvalidTokenException();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException();
        }
        return Integer.parseInt(result);
    }

    @Override
    public Integer parseRefreshToken(String token) {
        String result;
        try {
            Claims body = Jwts.parser().setSigningKey(SECURITY_KEY.getBytes()).parseClaimsJws(token).getBody();
            if (!body.get("type").equals("refresh_token")) throw new InvalidTokenException();
            result = body.get("uuid").toString();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException();
        }
        return Integer.parseInt(result);
    }

}