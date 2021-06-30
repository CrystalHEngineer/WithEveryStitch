package com.crystal.stitch.respositories;

import org.springframework.data.repository.CrudRepository;

import com.crystal.stitch.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
