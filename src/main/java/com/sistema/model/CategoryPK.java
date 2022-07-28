package com.sistema.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected Integer appId;
}
