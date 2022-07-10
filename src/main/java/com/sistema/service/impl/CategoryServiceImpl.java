package com.sistema.service.impl;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.repository.CategoryRepository;
import com.sistema.service.CategoryService;
import com.sistema.util.GlobalDefaultExceptionHandler;
import com.sistema.util.Result;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Result save(String body) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Long id, String body) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validateJson(JSONObject json) throws Exception {
		//validar json de category
	}

}
