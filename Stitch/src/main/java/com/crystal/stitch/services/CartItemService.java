package com.crystal.stitch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.CartItem;
import com.crystal.stitch.models.Product;
import com.crystal.stitch.respositories.CartItemRepository;
import com.crystal.stitch.respositories.ProductRepository;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepository cItemRepo;
	
	@Autowired
	private ProductRepository pRepo;
	
	//list of items by cart id
	public List<CartItem> listCartItems(Cart cart){
		return this.cItemRepo.findByCart(cart);
	}
	
	//add product to cart and edit quantity
	public CartItem addProduct(Long productId, Long quantity, Cart cart) {
		
		
		Long newQuantity= quantity;
		
		Product product = pRepo.findById(productId).orElse(null);
		
		CartItem cartItem = this.cItemRepo.findByCartAndProduct(cart, product);  
	
		if(cartItem != null) {
			
			cartItem.setQuantity(newQuantity);
			
//			Double newPrice = cartItem.getPrice() * cartItem.getQuantity();
//			
//			cartItem.setPrice(newPrice);
		}
		
		else {
			cartItem = new CartItem();
			cartItem.setQuantity(quantity);
			cartItem.setCart(cart);
			cartItem.setProduct(product);
		}		
		return this.cItemRepo.save(cartItem);	
	}
	
	
	//remove product completely from cart
	public void removeProduct( Long productId, Cart cart) {
		
		Product product = pRepo.findById(productId).orElse(null);
		
		CartItem cartItem = this.cItemRepo.findByCartAndProduct(cart, product); 
		
		this.cItemRepo.delete(cartItem);
		
	}
	
}
