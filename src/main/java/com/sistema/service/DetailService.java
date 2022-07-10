package com.sistema.service;

import com.sistema.util.Result;

public interface DetailService {
	
	Result save(String body) throws Exception;

	Result getAll();
	
	Result findDetail(Long id) throws Exception;
	
	Result update(Long id, String body) throws Exception;
	
	Result delete(Long id) throws Exception;
	
}
