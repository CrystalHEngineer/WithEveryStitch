package com.crystal.stitch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.CartItem;
import com.crystal.stitch.models.Guest;
import com.crystal.stitch.models.User;
import com.crystal.stitch.services.CartItemService;
import com.crystal.stitch.services.CartService;
import com.crystal.stitch.services.GuestService;
import com.crystal.stitch.services.UserService;

@Controller
public class CartController {
	
	@Autowired
	private GuestService guestServ;
	
	@Autowired 
	 private CartService cartServ;

	@Autowired 
	private CartItemService cItemServ;
	
	@Autowired
	private UserService uServ;
	
	///shows cart
	@GetMapping("/{guestId}/cart/{cartId}")
	public String cart( @PathVariable("guestId") Long guestId, @PathVariable("cartId") Long cartId , @ModelAttribute("order") Cart cart,HttpSession session, Model viewModel)  {
			System.out.println("Moving to the cart.");
		//sets current cart id through session			
		Long currentCartId = (Long) session.getAttribute("cart__id");
		viewModel.addAttribute("cart",this.cartServ.findCartbyId(currentCartId));
		
		if (session.getAttribute("theUserId") == null){	
			
			//this is need to get customer id for <a> tags and URLs 
			Guest currentGuest= this.guestServ.getGuestId();		
			viewModel.addAttribute("guest",currentGuest);
			
			//need this to compare and validated
			Cart currentCart = this.cartServ.findCartbyId(currentCartId);
			Cart accessCart = this.cartServ.findCartbyId(cartId);				
			//validates to check cart id to avoid URL manipulation
				if(accessCart != currentCart) {
					return "redirect:/"+currentGuest.getId()+"/"+currentCartId;
				}
			return "cart.jsp";	
		}
		
		else{
			Long currentUserId = (Long)session.getAttribute("theUserId");
			User currentUser= this.uServ.findUserById(currentUserId);
			viewModel.addAttribute("guest",currentUser);
			// needed for navbar tag <c:choose>
			viewModel.addAttribute("loginUser",currentUser);						
				//need this to compare and validated
			Cart currentCart = this.cartServ.findCartbyId(currentCartId);
			Cart accessCart = this.cartServ.findCartbyId(cartId);				
			//validates to check cart id to avoid URL manipulation
				if(accessCart != currentCart) {
					return "redirect:/"+currentUser.getId()+"/cart/"+currentCartId;
				}
				return "cart.jsp";	
		}						
	
	}
			//adds products to cart and will also edit quantity and price
	@PostMapping("/{guestId}/item/{productId}/add")
	public String addProductToCart(@ModelAttribute("newCartItem") CartItem newCartItem, BindingResult result,@PathVariable("guestId") Long guestId, @PathVariable("productId") Long productId, HttpSession session,Model viewModel) {	
				
				System.out.println("Added to the cart.");
				// gets cart from session
		Long currentCartId = (Long) session.getAttribute("cart__id");
				
				//get cart object
		Cart currentCart = this.cartServ.findCartbyId(currentCartId);
				
				//sets quantity of product	
		Long quantity = newCartItem.getQuantity();
				
				//calls service to save products using productId on URL, quantity choosen by customer, and cart from session to place products in to it
		this.cItemServ.addProduct(productId, quantity, currentCart);
						
				//to get customer id for redirect
		Guest guest = (Guest) session.getAttribute("guest");
				
		return "redirect:/"+guest.getId()+"/cart";		
				
	}	
			
			
			// removes product completely from cart by locating the cart using session and product id to removed that particular product
	@GetMapping("{guestId}/item/{productId}/remove")
	public String removeProductsFromCart( @PathVariable("guestId") Long guestId , @PathVariable("productId") Long productId, HttpSession session, Model viewModel) {		
				
				//gets cart 
		Long currentCartId = (Long) session.getAttribute("cart__id");
		Cart currentCart= this.cartServ.findCartbyId(currentCartId);
				
				
				//calls service to delete product	
		this.cItemServ.removeProduct(productId, currentCart);
				
				//gets current customer in order to redirect to cart 
		Long currentGuestId= (Long)session.getAttribute("guest");
				
		return "redirect:/" + currentGuestId + "/cart";
	}
	
	
	@GetMapping("/{guestId}/cart/{cartId}/checkout")
	public String cartCheckout( @PathVariable("guestId") Long guestId, @PathVariable("cartId") Long cartId , @ModelAttribute("order") Cart cart,HttpSession session, Model viewModel)  {
				
		//this is need to get customer id for <a> tags and URLs 
		Guest currentGuest= this.guestServ.getGuestId();		
		viewModel.addAttribute("guest",currentGuest);
				
		//sets current cart id through session
		Long currentCartId= (Long) session.getAttribute("cart__id");
		viewModel.addAttribute("cart",this.cartServ.findCartbyId(currentCartId));		
		
		//need this to compare and validated
		Cart currentCart = this.cartServ.findCartbyId(currentCartId);
		Cart accessCart = this.cartServ.findCartbyId(cartId);				
		//validates to check cart id to avoid URL manipulation
		if(accessCart != currentCart) {
			return "redirect:/"+currentGuest.getId()+"/"+currentCartId;
		}
		else {			
		
		return "orderReview.jsp";	
				}
	}
			
	@PostMapping("/{guestId}/cart/{cartId}/purchase")
	public String purchaseProductsi(@ModelAttribute("order") Cart cart, @PathVariable("guestId") Long guestId,  @PathVariable("cartId") Long cartId, HttpSession session, Model viewModel) {
					
		Guest guest = (Guest) session.getAttribute("guest");
		Long currentCartId= (Long) session.getAttribute("cart__id");
		Cart currentCart = this.cartServ.findCartbyId(currentCartId);
		this.cartServ.newOrder(currentCart, guest);
		return "receipt.jsp";
	}	
	

}
