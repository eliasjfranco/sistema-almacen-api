package com.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sistema.dto.ERole;

import lombok.Data;

@Entity
@Table(name = "ROLE")
@Data
public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	@Enumerated(EnumType.STRING)
	private ERole role;
}
