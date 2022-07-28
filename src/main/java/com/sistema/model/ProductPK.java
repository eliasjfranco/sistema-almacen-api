package com.sistema.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Long id;
	protected Integer appId;
}