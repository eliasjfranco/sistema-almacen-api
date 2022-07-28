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
@IdClass(CategoryPK.class)
@Table(name = "CATEGORIA")
public class Category {
	
	@Id
	@Column(name = "appid")
	private Integer appId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "id_producto")
	private Long productId;
	
}
