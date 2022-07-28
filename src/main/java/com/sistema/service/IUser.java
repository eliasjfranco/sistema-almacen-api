package com.sistema.service;

import java.util.Optional;

import com.sistema.model.User;
import com.sistema.util.Result;

public interface IUser {
	
	public Optional<User> getByEmail(String email);
	
	public Result login(String body) throws Exception;

}
