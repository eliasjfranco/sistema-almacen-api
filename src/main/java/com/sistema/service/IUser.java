package com.sistema.service;

import com.sistema.model.User;

public interface IUser {
	
	public User getByEmail(String email);

}
