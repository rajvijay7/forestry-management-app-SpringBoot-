package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Land;
import com.cg.fms.entities.Product;
import com.cg.fms.entities.User;
import com.cg.fms.exception.ProductAlreadyExistException;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
    Product findByName(String name) ;
	
	
}

