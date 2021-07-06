package com.crystal.stitch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crystal.stitch.models.User;
import com.crystal.stitch.services.CartService;
import com.crystal.stitch.services.ProductService;
import com.crystal.stitch.services.UserService;

@Controller
public class ProductController {
	@Autowired 
	private ProductService pService;
	@Autowired
	private UserService uServ;
	@ Autowired 
	private CartService cartServ;

	@GetMapping("/{categories}")
	public String products(@PathVariable("categories") String categories, Model viewModel, HttpSession session) {
		
		// needed for navbar tag <c:choose>
		Long currentUserId = (Long)session.getAttribute("theUserId");
		User currentUser= this.uServ.findUserById(currentUserId);
		viewModel.addAttribute("guest",currentUser);
		
		viewModel.addAttribute("loginUser",currentUser);
		Long currentCartId = (Long) session.getAttribute("cart__id");
		viewModel.addAttribute("cart",this.cartServ.findCartbyId(currentCartId));				

		
		if(categories.equals("mJackets")){
			viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "jacket"));
			}
			else if(categories.equals("mShirts")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "shirt"));
				} 
			else if(categories.equals("mPants")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "pant"));
				} 
			else if(categories.equals("wShirts")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("womens", "shirt"));
				} 
			else if(categories.equals("wJackets")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("womens", "jacket"));
				} 
			else if(categories.equals("wPants")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("womens", "pant"));
				} 
			return "product.jsp";
			} 
}