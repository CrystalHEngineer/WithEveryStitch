package com.crystal.stitch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crystal.stitch.models.Product;
import com.crystal.stitch.respositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository pRepo;
	
	public ProductService(ProductRepository repo) {
		this.pRepo = repo;
	}
	
	public List<Product> getAllProducts(){
		return this.pRepo.findAll();
	}
	
//	public List<Product> getGender(String gender){
//		return this.pRepo.findByGender(gender);
//	}
	
	public List<Product> getGenderAndItem(String gender, String item){
		System.out.println(this.pRepo.findByGenderAndItem(gender, item));
		return this.pRepo.findByGenderAndItem(gender, item);
	}
	
	
	public List<Product> getProducts(){
		return this.pRepo.findAll();
	}
	
	public Product getSingleProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public void deleteProduct(Long id) {
		this.pRepo.deleteById(id);
	}
	
//	public void addUser(User user, Product product) {
//		List<User> products = product.getCustomers();
//		users.add(user);
//		this.pRepo.save(product);
//	}
	
//	public void removeCustomer(User user, Product product) {
//		List<User> customers = product.getCustomers();
//		customers.remove(user);
//		this.pRepo.save(product);
//	}
}
