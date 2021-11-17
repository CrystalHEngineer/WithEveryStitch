package com.crystal.stitch.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

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
	
	@Value("${stripe.apikey}")
	String stripeKey;
	
	///shows cart
	@GetMapping("/{guestId}/cart/{cartId}")
	public String cart( @PathVariable("guestId") Long guestId, @PathVariable("cartId") Long cartId , @ModelAttribute("order") Cart cart,HttpSession session, Model viewModel)  {
			//System.out.println("Moving to the cart.");
		
		
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
			//updates fromcart
			this.cartServ.loginUpdateCart(currentCart, currentUser);
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
				
				//System.out.println("Added to the cart.");
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
				
		return "redirect:/"+guest.getId()+"/cart/" + currentCartId;
				
	}	
			
			
			// removes product completely from cart by locating the cart using session and product id to removed that particular product
	@GetMapping("{guestId}/item/{productId}/remove")
	public String removeProductsFromCart( @PathVariable("guestId") Long guestId , @PathVariable("productId") Long productId, HttpSession session, Model viewModel) {		
				
				//gets cart 
		Long currentCartId = (Long) session.getAttribute("cart__id");
		Cart currentCart= this.cartServ.findCartbyId(currentCartId);
				
				
				//calls service to delete product	
		this.cItemServ.removeProduct(productId, currentCart);
				

				
		return "redirect:/" + guestId + "/cart/"+ currentCartId;
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
	
		
	@GetMapping("/{guestId}/cart/{cartId}/receipt")
	public String receipt(@ModelAttribute("order") Cart cart, @PathVariable("guestId") Long guestId,  @PathVariable("cartId") Long cartId, HttpSession session, Model viewModel) {{
		Long currentCartId= (Long) session.getAttribute("cart__id");
		Cart currentCart = this.cartServ.findCartbyId(currentCartId);
		viewModel.addAttribute("cart",currentCart);
		
		if(session.getAttribute("theUserId")==null) {
			Guest guest = (Guest) session.getAttribute("guest");
			this.cartServ.newOrder(currentCart, guest);
			return "receipt.jsp";
		}
		
		else {
			Long currentUserId= (Long) session.getAttribute("theUserId");
			User currentUser= this.uServ.findUserById(currentUserId);
			viewModel.addAttribute("user",currentUser);
			this.cartServ.newOrderLogin(currentCart, currentUser);
			return "receipt.jsp";
			}
	}	
	}
	
	@PostMapping("/{guestId}/cart/{cartId}/purchase/{total}")
	public String purchaseProducts(HttpServletRequest request, @ModelAttribute("order") Cart cart, @PathVariable("guestId") Long guestId,  @PathVariable("cartId") Long cartId, @PathVariable("total") Double total, HttpSession session, Model viewModel) throws StripeException {
		
		Long currentCartId = (Long) session.getAttribute("cart__id");
		Cart currentCart = this.cartServ.findCartbyId(currentCartId);
		viewModel.addAttribute("cart",currentCart);
		
		if(session.getAttribute("theUserId")==null) {
			Guest guest = (Guest) session.getAttribute("guest");
			this.cartServ.newOrder(currentCart, guest);
//			return "redirect:/" + guest.getId() + "/cart/" + currentCartId + "/receipt";
			
			Stripe.apiKey = stripeKey;
			String token = request.getParameter("stripeToken");

			int totalCharge = (int) Math.round(total * 100);
			// Charge the user's card:
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("amount", totalCharge);
			params.put("currency", "usd");
			params.put("description", "Stripe Demo Charge");
			params.put("source", token);

			Charge charge = Charge.create(params);

			viewModel.addAttribute("checkoutPaySuccess", true);

			return "redirect:/" + guestId + "/cart/" + cartId + "/receipt";
			
		}
		
		else {
			Long currentUserId= (Long) session.getAttribute("theUserId");
			User currentUser= this.uServ.findUserById(currentUserId);
			viewModel.addAttribute("user",currentUser);
			this.cartServ.newOrderLogin(currentCart, currentUser);
			return "redirect:/" + guestId + "/cart/" + cartId + "/receipt";
			}
	}		

}
