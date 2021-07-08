package com.cg.fms.service;

import com.cg.fms.exception.ProductNotFoundException;
import com.cg.fms.exception.NumberFormatException;
import com.cg.fms.entities.Product;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Product;

@Service
public interface IProductService {

	
	

	 //GETTING PRODUCT BY ID
	Product fetchById(int id) throws ProductNotFoundException;
	
	
	 //GETTING PRODUCT BY NAME
	Product fetchByName(String name) throws ProductNotFoundException;
	
	
	
	 //ADDING A NEW PRODUCT
	Product addProduct(Product product);
	
	
	
	//UPDATE EXISTING PRODUCT 
	void  updateProduct(Product product);
	
	
	
	//DELETING AN EXISTING PRODUCT WITH ID
	void delProduct(int id) throws ProductNotFoundException;
	
	
	
	// LIST ALL PRODUCTS
	List<Product> fetchAll();
	
	
}
