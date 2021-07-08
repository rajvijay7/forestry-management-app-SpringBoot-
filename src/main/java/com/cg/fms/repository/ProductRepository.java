package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Land;
import com.cg.fms.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	 Product findByName(String name);
	
	
}

