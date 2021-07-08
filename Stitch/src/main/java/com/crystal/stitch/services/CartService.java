package com.crystal.stitch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.Guest;
import com.crystal.stitch.models.User;
import com.crystal.stitch.respositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	// make guest cart
	public Cart newCart(Cart newCart, Guest currentGuest) {
		
		newCart.setGuest(currentGuest);
		newCart.setOrder("no");
		return this.cartRepo.save(newCart);
		
	}
	
	// make guest cart
		public Cart newUserCart(Cart newCart, User currentUser) {
			
			newCart.setUser(currentUser);
			newCart.setOrder("no");
			return this.cartRepo.save(newCart);
			
		}
	
	//find cart my id
	public Cart findCartbyId(Long id) {
		
		return this.cartRepo.findById(id).orElse(null);		
	}
	//updates cart from guest to user
	public Cart loginUpdateCart(Cart currentCart, User currentUser) {
		currentCart.setUser(currentUser);
		return this.cartRepo.save(currentCart);
	}
	
	//send order as Guest
	public Cart newOrder(Cart currentcart, Guest currentGuest) {
		currentcart.setGuest(currentGuest);
		currentcart.setOrder("yes");
		return this.cartRepo.save(currentcart);
	}
	
	//send order as Login User
	public Cart newOrderLogin(Cart currentcart, User currentUser) {
		currentcart.setUser(currentUser);
		currentcart.setOrder("yes");
		return this.cartRepo.save(currentcart);
	}
	
}

