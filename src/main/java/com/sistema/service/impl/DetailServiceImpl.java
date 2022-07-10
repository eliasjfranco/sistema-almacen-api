package com.sistema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.repository.DetailRepository;
import com.sistema.service.DetailService;
import com.sistema.util.Result;

@Service
public class DetailServiceImpl implements DetailService{
	
	@Autowired
	DetailRepository detailRepository;

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
	public Result findDetail(Long id) throws Exception {
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

}
