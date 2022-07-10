package com.sistema.service;

import com.sistema.util.Result;

public interface CategoryService {
	
	Result save(String body) throws Exception;
	
	Result getAll();
	
	Result update(Long id, String body) throws Exception;
	
	Result delete(Long id) throws Exception;

}
