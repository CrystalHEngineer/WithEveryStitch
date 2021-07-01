package com.crystal.stitch.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystal.stitch.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
 	List<Product> findAll();
	List<Product> findByGenderAndItem(String gender, String item);
 }
