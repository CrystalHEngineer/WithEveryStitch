package com.crystal.stitch.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crystal.stitch.validators.UserValidator;
import com.crystal.stitch.models.User;
import com.crystal.stitch.services.UserService;

@Controller
public class UserController {
	
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
			
			return "cart.jsp";
				
		}
		
		else {
			
			redirectAttributes.addFlashAttribute("logerror", "Please enter valid email or password");
			return "redirect:/guestpurchasepage";
			
		}
	}
	
	@RequestMapping("/registerpage")
	public String userRegister(@ModelAttribute("newuser") User newuser) {
		
		
		return "register.jsp";
		
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
			
			//System.out.println("good to go");
			return "redirect:/guestpurchasepage";
			
		}
		
		
		
		
	}

}
