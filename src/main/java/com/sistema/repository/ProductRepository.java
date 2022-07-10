package com.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "Select p from Productos p where p.nombre = ?1 and p.detalle = ?2", nativeQuery = true)
	Optional<Product> findByNameAndDetail(String name, String detail);
	
}
