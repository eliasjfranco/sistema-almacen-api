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
@IdClass(DetailPK.class)
@Table(name = "DETALLE")
public class Detail {
	
	@Id
	@Column(name = "appid")
	private Integer appId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "cantidad")
	private Integer amount;
	
	@Column(name = "precio")
	private Float price;
	
	@Column(name = "id_producto")
	private Long idProduct;

}
