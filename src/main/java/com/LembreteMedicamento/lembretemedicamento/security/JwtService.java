package com.LembreteMedicamento.lembretemedicamento.security;

import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
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

    public String pegarEmail(String token){
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getChaveAssinatura())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValido(String token, Usuario usuario){
        final String nome = pegarEmail(token);
        return (nome.equals(usuario.getEmail()) && !tokenExpirado(token));
    }

    private boolean tokenExpirado(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Key getChaveAssinatura() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
