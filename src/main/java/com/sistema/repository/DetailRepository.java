package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.model.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long>{

}
