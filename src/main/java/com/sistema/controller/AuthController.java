package com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.service.IUser;
import com.sistema.util.Result;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	IUser service;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Result login(@RequestBody String body) throws Exception {
		return service.login(body);
	}
	
}
