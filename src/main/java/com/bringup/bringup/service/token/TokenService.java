package com.bringup.bringup.service.token;

public interface TokenService {
    String generateAccessToken(Integer data);
    String generateRefreshToken(Integer data);
    Integer parseToken(String token);
    Integer parseRefreshToken(String token);
}
