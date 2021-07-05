package com.crystal.stitch.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.Feedback;
import com.crystal.stitch.models.Guest;
import com.crystal.stitch.models.User;
import com.crystal.stitch.services.CartService;
import com.crystal.stitch.services.FeedbackService;
import com.crystal.stitch.services.GuestService;
import com.crystal.stitch.services.ProductService;
import com.crystal.stitch.services.UserService;


@Controller
public class WebsiteController {

	@Autowired
	private FeedbackService fService;		
	@Autowired
	private ProductService productServ;	
	@Autowired 
	 private CartService cartServ;
	@Autowired
	private GuestService guestServ;
	@Autowired
	private UserService uServ;
	
	@GetMapping("/")
	public String displayLanding(HttpSession session, Model viewModel) {
		
		if (session.getAttribute("theUserId") == null){	
				
			//this makes the first and only guest Object if DB is empty
			Guest currentGuest= this.guestServ.getGuestId();
			
			if(currentGuest==null) {
				Guest firstGuest = new Guest();
				this.guestServ.saveFirstGuest(firstGuest);
				return "redirect:/";
			}
			else {	
				
				//set a customer as a default guest in session
				session.setAttribute("guest", currentGuest);
							
				//checks if there is a cart in session,				
				if(session.getAttribute("cart__id")==null){
					
					Cart newCart = new Cart();
					
					//saves cart and saves it to the default guest 
					this.cartServ.newCart(newCart, currentGuest);
					
					//sets new cart id in session
					session.setAttribute("cart__id", newCart.getId());
				
					return "redirect:/";
				}
				
				//return "redirect:/";
			}	
							
				///checks if current cart has been purchased
				Long currentCartId = (Long) session.getAttribute("cart__id");
				Cart currectCart = this.cartServ.findCartbyId(currentCartId);
			
				//sets cart id in viewModel to have access to {cartId} in URLs 
				viewModel.addAttribute("cart",this.cartServ.findCartbyId(currentCartId));
			
				if(currectCart.getOrder().equals("yes")) {
					session.setAttribute("cart__id", null);
				
					return "redirect:/";
				}
			
				return "index.jsp";
		}
		
		else{
			
			Long currentUserId = (Long)session.getAttribute("theUserId");
			User currentUser= this.uServ.findUserById(currentUserId);
			viewModel.addAttribute("guest",currentUser);
			// needed for navbar tag <c:choose>
			viewModel.addAttribute("loginUser",currentUser);
			Long currentCartId = (Long) session.getAttribute("cart__id");
			viewModel.addAttribute("cart",this.cartServ.findCartbyId(currentCartId));				
			return "index.jsp";
		}
	
	}
	
	@GetMapping("/about")
	public String about() {
		return "about.jsp";
	}	

	@GetMapping("/contact")
	public String contact(@ModelAttribute("feedback") Feedback feedback) {	
		return "contact.jsp";
	}

	@PostMapping("/contact/new")
	public String addFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result) {
		if (result.hasErrors()) {
			return "contact.jsp";
		} else {
			fService.createFeedback(feedback);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}

