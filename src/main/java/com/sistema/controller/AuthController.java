package com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String asd() {
		System.out.println("ingrese");
		RestTemplate rest = new RestTemplate();
		for(int i = 0; i<50; i++) {
			ResponseEntity<String> response = rest.postForEntity("http://localhost:8081/auth/test2", "asd", String.class);
			System.out.println("Response" + i + ": " + response.getBody());
		}
		return "finish";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String asd2(@RequestBody String asd) {
		return "test webhook";
	}
	
	
}
