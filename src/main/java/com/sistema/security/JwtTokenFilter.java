package com.sistema.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sistema.service.impl.UserDetailsServiceImpl;
import com.sistema.util.Constants;

public class JwtTokenFilter extends OncePerRequestFilter{

	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	UserDetailsServiceImpl userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(request);
			
			if (token != null && jwtProvider.validateToken(token)) {
				
				String user = jwtProvider.getEmailFromToken(token);
				UserDetails userDetails = userService.loadUserByUsername(user);
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
			
		} catch (Exception e) {
			logger.error("Fallo en el metodo filtro " + e.getMessage());
		}
		filterChain.doFilter(request, response);
		
	}
	
	private String getToken(HttpServletRequest req) {
		String header = req.getHeader(Constants.HEADER_AUTH);
		if (header != null && header.startsWith(Constants.PREFIX_JWT))
			return header.replace(Constants.PREFIX_JWT, "");
		return null;
	}

	
	
}
