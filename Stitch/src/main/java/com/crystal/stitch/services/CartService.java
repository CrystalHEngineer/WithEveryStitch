package com.crystal.stitch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.Guest;
import com.crystal.stitch.respositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	// make cart
	public Cart newCart(Cart newCart, Guest currentGuest) {
		
		newCart.setGuest(currentGuest);
		newCart.setOrder("no");
		return this.cartRepo.save(newCart);
		
	}
	
	//find cart my id
	public Cart findCartbyId(Long id) {
		
		return this.cartRepo.findById(id).orElse(null);
		
	}
	
	
	
	//update cart and send order
	public Cart newOrder(Cart currentcart, Guest currentGuest) {
		currentcart.setGuest(currentGuest);
		currentcart.setOrder("yes");
		return this.cartRepo.save(currentcart);
	}
}

