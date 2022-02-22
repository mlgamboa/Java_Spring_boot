package com.pointwest.capstone.config;

import com.pointwest.capstone.models.User;
import com.pointwest.capstone.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtToken implements Serializable {

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private UserRepository userRepository;
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 10*60*60;

    private String doGenerateToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String generateToke(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        User user = userRepository.findByUsername(userDetails.getUsername());
        claims.put("user", user.getId());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims CLAIMS = getAllClaimsFromToken(token);
        return claimsResolver.apply(CLAIMS);
    }

    public String getUsernameFromToken(String token){
        String claim = getClaimFromToken(token, Claims::getSubject);
        return claim;
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token){
        final Date EXPIRATION = getExpirationDateFromToken(token);
        return EXPIRATION.before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String USERNAME = getUsernameFromToken(token);
        return (USERNAME.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

}
