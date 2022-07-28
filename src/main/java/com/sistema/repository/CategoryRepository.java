package com.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "select * from Categoria where id = ?1 and appid = ?2", nativeQuery = true)
	Optional<Category> findByIdAndAppId(Long id, Integer appId);

	@Query(value = "select * from Categoria where name = ?1 and appid = ?2", nativeQuery = true)
	Optional<Category> findByNameAndAppId(String name, Integer appId);
}
