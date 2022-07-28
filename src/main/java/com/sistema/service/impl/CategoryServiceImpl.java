package com.sistema.service.impl;

import java.util.Optional;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.model.Category;
import com.sistema.repository.CategoryRepository;
import com.sistema.service.CategoryService;
import com.sistema.util.Constants;
import com.sistema.util.GlobalDefaultExceptionHandler;
import com.sistema.util.Result;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Result save(String body) throws Exception {
		JSONObject object = new JSONObject(body);
		Integer appId = null;
		this.validateJson(object);
		
		Category category = new Category();
		category.setName(object.getString("name"));
		category.setProductId(object.getLong("productId"));
		if(!existsWithNameAndAppId(category.getName(), appId))
			return new Result(Constants.RESULT_OK, categoryRepository.save(category));
		else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_CATEGORY_EXISTS.getError_code());
	}

	@Override
	public Result getAll() {
		return new Result(Constants.RESULT_OK, categoryRepository.findAll());	
	}

	@Override
	public Result update(Long id, String body) throws Exception {
		Integer appId = null;
		JSONObject object = new JSONObject(body);
		this.validateJson(object);
		Category category = getCategory(id, appId);
		if (!category.getName().equalsIgnoreCase(object.getString("name"))) {
			if (!existsWithNameAndAppId(object.getString("name"), appId)) {
				category.setName(object.getString("name"));
				return new Result(Constants.RESULT_OK, categoryRepository.save(category));
			} else
				throw new Exception(GlobalDefaultExceptionHandler.ERR_CATEGORY_EXISTS.getError_code());
		}
		return new Result(Constants.RESULT_OK, category);
	}

	@Override
	public Result delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validateJson(JSONObject json) throws Exception {
		if(json.has("name") && json.get("name") != null) {
			if(json.getString("name").isEmpty())
				throw new Exception(GlobalDefaultExceptionHandler.ERR_NAME_PARAM.getError_code());
		} else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_NAME_PARAM.getError_code());

		if(json.has("productId") && json.get("productId") != null) {
			if(json.getString("productId").isEmpty())
				throw new Exception(GlobalDefaultExceptionHandler.ERR_PRODUCT_PARAM.getError_code());
		} else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_PRODUCT_PARAM.getError_code());
	}
	
	private Boolean existsWithNameAndAppId(String name, Integer appId) {
		Optional<Category> category = categoryRepository.findByNameAndAppId(name, appId);
		return category.isPresent();
	}
	
	private Category getCategory(Long id, Integer appId) throws Exception {
		Optional<Category> category = categoryRepository.findByIdAndAppId(id, appId);
		if (category.isPresent())
			return category.get();
		else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_CATEGORY_NOT_EXISTS.getError_code());
	}

}
