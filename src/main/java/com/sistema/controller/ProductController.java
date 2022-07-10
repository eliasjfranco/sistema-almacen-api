package com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.service.ProductService;
import com.sistema.util.Result;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result saveProduct(@RequestBody String body) throws Exception {
		return productService.save(body);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Result getProducts() {
		return productService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result findProduct(@PathVariable("id") Long id) throws Exception {
		return productService.findProduct(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateProduct(@PathVariable("id") Long id, @RequestBody String body) throws Exception {
		return productService.update(id, body);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteProduct(@PathVariable("id") Long id) throws Exception {
		return productService.delete(id);
	}

}
