package com.techquest.app_TechQuest.infrastructure.helpers;

import com.techquest.app_TechQuest.domain.model.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTService {

    //crear firma o clave secreta con base64
    private final String SECRET_KEY = "bWlzdXBlcmNsYXZlc2VjcmV0YW11eWxhcmdhcVkYWFkaXZpbmFyamFqYWphGFyYXF1ZW5hZGllbGFwdW";

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

    //Metodo para generar e inyectar los claims del jwt

    public String getToken(UserEntity user){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("role",user.getRole().name());

        return getToken(claims,user);
    }

    //Metodo para obtener los claims del token

    public Claims extractAllClaims (String token){

       return Jwts
               .parserBuilder()
               .setSigningKey(getKey())
               .build()
               .parseClaimsJwt(token)
               .getBody();
    }

    //Obtiene todos los claims que se recibe y cn la funtion claimsResolver obtenngo solo el claim que nesecito
    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){

        final Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    //Obtiene el username del claim

    public String getUsernameFromToken(String token){
        return getClaim(token,Claims::getSubject);
    }

    //Obtiene la fecha de expiracion del claim
    public Date getDateExpirationFromToken(String token){
        return getClaim(token,Claims::getExpiration);
    }

    //Metodos para validar el token

    public Boolean isTokenExpired(String token){
        return getDateExpirationFromToken(token).before(new Date());
    }

//    public Boolean isTokenValid(String token, UserDetails userDetails){
//        String email =
//    }




}
