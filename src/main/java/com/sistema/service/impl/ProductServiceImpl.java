package com.sistema.service.impl;

import java.util.Optional;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.model.Product;
import com.sistema.repository.ProductRepository;
import com.sistema.service.ProductService;
import com.sistema.util.Constants;
import com.sistema.util.GlobalDefaultExceptionHandler;
import com.sistema.util.Result;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Result save(String body) throws Exception {
		JSONObject object = new JSONObject(body);
		this.validateJson(object);
		
		Product product = new Product();
		product.setDetail(object.getString("detail"));
		product.setName(object.getString("name"));
		if(!existsWithNameAndDetail(product.getName(), product.getDetail()))
			return new Result(Constants.RESULT_OK, productRepository.save(product));
		else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_PRODUCT_EXISTS.getError_code());
	}

	@Override
	public Result getAll() {
		return new Result(Constants.RESULT_OK, productRepository.findAll());
	}

	@Override
	public Result findProduct(Long id) throws Exception {
		return new Result(Constants.RESULT_OK, getProduct(id));
	}

	@Override
	public Result update(Long id, String body) throws Exception {
		JSONObject object = new JSONObject(body);
		this.validateJson(object);
		Product product = getProduct(id);
		if(!existsWithNameAndDetail(object.getString("name"), object.getString("detail"))) {
			return new Result(Constants.RESULT_OK, productRepository.save(product));
		} else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_PRODUCT_EXISTS.getError_code());
				
	}

	@Override
	public Result delete(Long id) throws Exception {
		Product product = getProduct(id);
		productRepository.delete(product);
		return new Result(Constants.RESULT_OK, Constants.PRODUCT_DELETED);
	}
	
	private Product getProduct(Long id) throws Exception {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent())
			return product.get();
		else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_PRODUCT_NOT_EXISTS.getError_code(), new Throwable(id.toString()));
	}
	
	private Boolean existsWithNameAndDetail(String name, String detail) throws Exception {
		Optional<Product> p = productRepository.findByNameAndDetail(name, detail);
		return p.isPresent();
	}
	
	private void validateJson(JSONObject json) throws Exception {
		if(json.has("detail") && json.get("detail") != null) {
			if(json.getString("detail").isEmpty())
				throw new Exception(GlobalDefaultExceptionHandler.ERR_DETAIL_PARAM.getError_code());
		} else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_DETAIL_PARAM.getError_code());

		if(json.has("name") && json.get("name") != null) {
			if(json.getString("name").isEmpty())
				throw new Exception(GlobalDefaultExceptionHandler.ERR_NAME_PARAM.getError_code());
		} else
			throw new Exception(GlobalDefaultExceptionHandler.ERR_NAME_PARAM.getError_code());
	}

}
