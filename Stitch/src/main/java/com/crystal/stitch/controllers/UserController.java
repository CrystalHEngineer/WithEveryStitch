package com.crystal.stitch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crystal.stitch.models.User;
import com.crystal.stitch.services.UserService;

@Controller
public class UserController {
	
	private final UserService userSer;
	
	public UserController(UserService userSer) {
		
		this.userSer = userSer;
	}
	
	@RequestMapping("/guestpurchasepage")
	
	public String guestdecidepage() {
		
		
		
		return "register.jsp";
	}
	
	@PostMapping("/login")
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

}
