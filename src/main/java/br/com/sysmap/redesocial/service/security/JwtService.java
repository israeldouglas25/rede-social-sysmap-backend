package br.com.sysmap.redesocial.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService implements IJwtService {

    private final long EXPIRATION_TIME = 7200000;
    private final String KEY = "413F442A472D4B6150645367566B59703373367639792442264529482B4D6251";

    public String generateToken(UUID userId){
        return Jwts
                .builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(genSingInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidToken(String token, String userId){
        var sub = getClaim(token, Claims::getSubject);
        var tExpiration = getClaim(token, Claims::getExpiration);

        if (!sub.equals(userId)){
            return false;
        }

        if (tExpiration.before(new Date())){
            return false;
        }

        return true;
    }

    private <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        var claims = Jwts
                .parserBuilder()
                .setSigningKey(genSingInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claimsResolver.apply(claims);
    }

    private Key genSingInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
    }
}
