package com.sistema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.repository.SaleRepository;
import com.sistema.service.SaleService;
import com.sistema.util.Result;

@Service
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	SaleRepository saleRepository;

	@Override
	public Result save(String body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
