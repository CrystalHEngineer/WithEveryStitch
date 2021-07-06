package com.crystal.stitch.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crystal.stitch.validators.UserValidator;
import com.crystal.stitch.models.Cart;
import com.crystal.stitch.models.Guest;
import com.crystal.stitch.models.User;
import com.crystal.stitch.services.CartService;
import com.crystal.stitch.services.GuestService;
import com.crystal.stitch.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private CartService cartServ;
	
	@Autowired
	private GuestService guestServ;
	
	
	private final UserService userSer;
	private final UserValidator userVal;
	
	public UserController(UserService userSer,UserValidator userVal) {
		
		this.userSer = userSer;
		this.userVal = userVal;
	}
	
	@RequestMapping("/guestpurchase")
	
	public String guestdecidepage() {
		
		
		
		return "guest.jsp";
	}
	
	@PostMapping("/loginguser")
	public String userlogin(@RequestParam(value = "inputemail") String inputemail,
							@RequestParam(value = "inputpassword") String inputpass,
							HttpSession session,RedirectAttributes redirectAttributes) {
		
		if(this.userSer.authenticateUser(inputemail, inputpass)) {
			
			User theUser = this.userSer.findUserByEmail(inputemail);
			Long theUserId = theUser.getId();
			session.setAttribute("theUserId", theUserId);
			Long currentCartId = (Long) session.getAttribute("cart__id");
			return "redirect:/" + theUserId + "/cart/" + currentCartId;
			
				
		}
		
		else {
			
			redirectAttributes.addFlashAttribute("logerror", "Please enter valid email or password");
			return "redirect:/registerpage";
			
		}
	}
	
	@RequestMapping("/registerpage")
	public String userRegister(@ModelAttribute("newuser") User newuser, HttpSession session, Model viewModel) {
		Long currentCartId = (Long) session.getAttribute("cart__id");
		Cart currentCart = this.cartServ.findCartbyId(currentCartId);
		viewModel.addAttribute("cart",currentCart);
		viewModel.addAttribute("cart_id",currentCartId);
		
		if (session.getAttribute("theUserId") == null){
			Guest currentGuest= this.guestServ.getGuestId();
			viewModel.addAttribute("guest",currentGuest);
			
			return "register.jsp";
		}
		else {
			Long currentUserId = (Long) session.getAttribute("theUserId");
			User currentUser = this.userSer.findUserById(currentUserId);
			viewModel.addAttribute("guest", currentUser);
				
		
			return "register.jsp";
		}

		
	}
	
	@PostMapping("/registuser")
	public String registerasuser(@Valid @ModelAttribute("newuser") User newuser, BindingResult result,
								 RedirectAttributes redirectAttributes, HttpSession session) {
		
		this.userVal.validate(newuser, result);
		
		if(result.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("regerror", "Email already existed or password not match");
			//System.out.println("error");
			return "redirect:/registerpage";
		}
		
		else {
			
			User newUser = this.userSer.registerUser(newuser);
			Long theUserId = newUser.getId();
			session.setAttribute("theUserId", theUserId);
			
			Long currentCartId = (Long) session.getAttribute("cart__id");
			//System.out.println("good to go");
			return "redirect:/" + theUserId + "/cart/" + currentCartId;
			
		}
		
		
		
		
	}

}
