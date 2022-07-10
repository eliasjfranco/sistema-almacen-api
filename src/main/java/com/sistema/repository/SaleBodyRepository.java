package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.model.SaleBody;

@Repository
public interface SaleBodyRepository extends JpaRepository<SaleBody, Long>{

}
