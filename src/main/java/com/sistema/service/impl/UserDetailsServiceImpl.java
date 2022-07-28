package com.sistema.service.impl;

import java.util.Optional;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sistema.model.User;
import com.sistema.repository.UserRepository;
import com.sistema.security.JwtProvider;
import com.sistema.service.IUser;
import com.sistema.util.Constants;
import com.sistema.util.GlobalDefaultExceptionHandler;
import com.sistema.util.Result;


public class UserDetailsServiceImpl implements IUser,UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	JwtProvider provider;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = getByEmail(email).get();
		if(user != null)
			return User.build(user);
		else
			throw new UsernameNotFoundException(GlobalDefaultExceptionHandler.ERR_USER_NOT_EXISTS.getError_code());
		
	}

	@Override
	public Optional<User> getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Result login(String body) throws Exception {
		verifyLogin(body);
		JSONObject json = new JSONObject(body);
		User user = userRepository.findUserByDocument(json.getString("document"));
		if(user == null)
			throw new Exception(GlobalDefaultExceptionHandler.ERR_USER_NOT_EXISTS.getError_code());
		else
			if(!encoder.matches(json.getString("password"), user.getPassword()))
				throw new Exception(GlobalDefaultExceptionHandler.ERR_USER_PASSWORD_NOT.getError_code());
		
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(json.getString("document"), json.getString("password")));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new Result(Constants.RESULT_OK,provider.generateToken(authentication));
	}
	
	private void verifyLogin(String body) throws Exception {
		JSONObject json = new JSONObject(body);
		if (json.has("document") && json.has("password")) {
			if(json.getString("document").isEmpty() || json.getString("password").isEmpty())
				throw new Exception(GlobalDefaultExceptionHandler.ERR_LOGIN_PARAM.getError_code());
		}
	}

	
	
}
