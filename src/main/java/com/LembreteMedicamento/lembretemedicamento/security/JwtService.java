package com.LembreteMedicamento.lembretemedicamento.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.Date;

public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String gerarToken(String email){
        Key chave = getChaveAssinatura();

        Date dataAtual = new Date();
        Date expiracao = new Date(dataAtual.getTime() + 1000 * 60 * 60);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(dataAtual)
                .setExpiration(expiracao)
                .signWith(chave, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    private Key getChaveAssinatura() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
