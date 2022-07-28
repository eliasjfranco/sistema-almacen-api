package com.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@IdClass(ProductPK.class)
@Table(name = "PRODUCTO")
public class Product {
	
	@Id
	@Column(name = "appid")
	private Integer appId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "detalle", length = 50)
	private String detail;
	
	@Column(name = "nombre", length = 50)
	private String name;
	
}
