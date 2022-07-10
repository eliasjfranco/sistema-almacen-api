package com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.service.DetailService;
import com.sistema.util.Result;

@Controller
@RequestMapping("/detail")
public class DetailController {
	
	@Autowired
	DetailService detailService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result saveDetail(@RequestBody String body) throws Exception {
		return detailService.save(body);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Result getDetails() {
		return detailService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result findDetails(@PathVariable("id") Long id) throws Exception {
		return detailService.findDetail(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateDetail(@PathVariable("id") Long id, @RequestBody String body) throws Exception {
		return detailService.update(id, body);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteDetail(@PathVariable("id") Long id) throws Exception {
		return detailService.delete(id);
	}

}
