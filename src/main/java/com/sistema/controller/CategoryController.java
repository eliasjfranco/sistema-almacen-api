package com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.service.CategoryService;
import com.sistema.util.Result;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result saveCategory(@RequestBody String body) throws Exception {
		return categoryService.save(body);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Result getCategories() {
		return categoryService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateCategory(@PathVariable("id") Long id, @RequestBody String body) throws Exception {
		return categoryService.update(id, body);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteCategory(@PathVariable("id") Long id) throws Exception {
		return categoryService.delete(id);
	}

}
