//package com.example.Appointment.System.JWT;
//
//import com.example.Appointment.System.DATA.Entity.MUser;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    @Value("${jwt.secret}")
//    private String secretKey;
//
//    @Value("${jwt.expiration-ms}")
//    private long expirationMs;
//
//    public String generateToken(MUser user) {
//        Date now = new Date();
//        Date expiry = new Date(now.getTime() + expirationMs);
//        return Jwts.builder()
//                .setSubject(user.getName())
//                .setIssuedAt(now)
//                .setExpiration(expiry)
//                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return parseClaims(token).getSubject();
//    }
//
//    public boolean validateToken(String token, MUser user) {
//        String username = extractUsername(token);
//        return username.equals(user.getName())
//                && !parseClaims(token).getExpiration().before(new Date());
//    }
//
//    private Claims parseClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}