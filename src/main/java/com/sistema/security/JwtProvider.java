package com.sistema.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import com.sistema.model.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtProvider {
	
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		return "Bearer " + Jwts.builder().setSubject(user.getUsername())
				.claim("name", user.getFirstname() + " " + user.getLastname())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public String getEmailFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Token mal formado");
			return false;
		} catch (UnsupportedJwtException e) {
			logger.error("Token expirado");
			return false;
		} catch (ExpiredJwtException e2) {
			logger.error("Token expirado");
			return false;
		} catch (IllegalArgumentException e) {
			logger.error("Token vacio");
			return false;
		} catch (SignatureException e) {
			logger.error("Fallo con la firma");
			return false;
		}
	}

}
