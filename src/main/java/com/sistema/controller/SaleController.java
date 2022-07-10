package com.sistema.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistema.service.SaleService;
import com.sistema.util.Result;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	SaleService saleService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Result saveSale(@RequestBody String body) {
		return saleService.save(body);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Result getSales(@RequestParam(name = "date", required = false) Date date) throws Exception {
		return saleService.getAll();
	}

}
