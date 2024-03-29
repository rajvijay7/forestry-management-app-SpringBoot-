package com.cg.fms.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.ConfirmPasswordException;
import com.cg.fms.exception.ProductAlreadyExistException;
import com.cg.fms.exception.ProductNotFoundException;
import com.cg.fms.exception.UserEmailAlreadyExistException;
import com.cg.fms.exception.UserNameException;
import com.cg.fms.entities.Product;
import com.cg.fms.entities.User;
import com.cg.fms.repository.ProductRepository;
import com.cg.fms.service.ProductServiceImpl;

@Service
public class ProductServiceImpl implements IProductService {

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository repository; // DEPENDENCY OF IMPLEMENTATION

	
	
	
	
	
	// GETTING PRODUCT BY ID
	@Override
	public Product fetchById(int id) throws ProductNotFoundException {
		Optional<Product> product = repository.findById(id);
		if (!product.isPresent())
			throw new ProductNotFoundException();
		return product.get();
	}
	
	
	
	
	

	// GETTING PRODUCT BY NAME
	@Override
	public Product fetchByName(String name) throws ProductNotFoundException {
		logger.info("inside fetchByName method of ProductServiceImpl");
		return repository.findByName(name);
	}
	
	
	
	
	
	
	

	// CHECK IF PRODUCT EXIST ALREADY
	public boolean checkIfProductAlreadyExist(String name) {
		return repository.findByName(name) != null ? true : false;
	}


	
	// ADDING A NEW PRODUCT

	@Override
	public Product addProduct(Product product) throws ProductAlreadyExistException {

		if (checkIfProductAlreadyExist(product.getName())) {
			throw new ProductAlreadyExistException();
		}

		logger.info("inside addProduct method of ProductServiceImpl");
		return repository.save(product);
	}

	
	
	
	
	
	
	// UPDATE EXISTING PRODUCT

	@Override
	public void updateProduct(Product product) {
		repository.save(product);
	}
	
	
	
	
	
	
	

	// DELETING AN EXISTING PRODUCT WITH ID

	@Override
	public void delProduct(int id) throws ProductNotFoundException {
		Optional<Product> product = repository.findById(id);
		if (!product.isPresent())
			throw new ProductNotFoundException();

		repository.deleteById(id);
	}
	
	
	
	
	
	
	

	// LIST ALL PRODUCTS
	@Override
	public List<Product> fetchAll() {
		return repository.findAll();
	}






	
	
}
