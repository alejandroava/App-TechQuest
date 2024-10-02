package com.techquest.app_TechQuest.infrastructure.helpers;

import com.techquest.app_TechQuest.domain.model.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTService {

    //crear firma o clave secreta con base64
    private final String SECRET_KEY = "bWljbGF2ZXNlY3JldGFuYWRpZWxhcHVlZGVzYWJlcg==";

    //Metodo para cifrar la clave secreta
    public SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //Metodo para generar el jwt
    public String getToken(Map<String,Object> claims, UserEntity user){

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 *60 *24))
                .signWith(getKey())
                .compact();
    }

    //Metodo para obtener el jwt

    public String getToken(UserEntity user){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("role",user.getRole().name());

        return getToken(claims,user);
    }

}
