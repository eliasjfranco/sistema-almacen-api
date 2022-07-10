package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
