package com.crystal.stitch.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.CartItem;
import com.crystal.stitch.models.Product;

@Repository
public interface CartItemRepository extends CrudRepository <CartItem, Long> {
	
	///find cart list
	List <CartItem> findByCart(Cart cart);
	
	//add or edit to cart
	CartItem findByCartAndProduct(Cart cart, Product product);
	

}
