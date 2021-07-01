package com.crystal.stitch.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crystal.stitch.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
 	List<Product> findAll();
	List<Product> findByGenderAndItem(String gender, String item);
 }
