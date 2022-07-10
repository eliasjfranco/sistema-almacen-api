package com.sistema.service;

import com.sistema.util.Result;

public interface ProductService {
	
	Result save(String body) throws Exception;
	
	Result getAll();
	
	Result findProduct(Long id) throws Exception;
	
	Result update(Long id, String body) throws Exception;
	
	Result delete(Long id) throws Exception;

}
