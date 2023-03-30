package br.com.eguadordorigo.adopet.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "50645367566B5970337336763979244226452948404D6251655468576D5A7134";

    public String extrairEmailDoJwt(String token) {
        return extrairClaims(token, Claims::getSubject);
    }

    private Claims extrairTodosOsClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(buscarChaveDeAssinatura())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    public <T> T extrairClaims(String token, Function<Claims, T> claimResolver){
        Claims claims = extrairTodosOsClaims(token);
        return claimResolver.apply(claims);
    }

    public String gerarToken(UserDetails userDetails){
        return gerarToken(new HashMap<>(), userDetails);
    }

    public String gerarToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(buscarChaveDeAssinatura(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean oTokenEstaValido(String token, UserDetails userDetails){
        final String nomeUsuario = extrairEmailDoJwt(token);
        return (nomeUsuario.equals(userDetails.getUsername())) && !oTokenEstaExpirado(token);
    }

    private boolean oTokenEstaExpirado(String token) {
        return extrairExpiracao(token).before(new Date());
    }

    private Date extrairExpiracao(String token) {
        extrairClaims(token, Claims::getExpiration);
        return null;
    }

    private Key buscarChaveDeAssinatura() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
