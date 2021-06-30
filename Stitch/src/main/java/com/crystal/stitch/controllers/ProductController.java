package com.crystal.stitch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crystal.stitch.services.ProductService;
@Controller
public class ProductController {
	@Autowired 
	private ProductService pService;
	
	
	@GetMapping("/")
	public String test() {
		return "products.jsp";
	}
	
	@GetMapping("/")
	public String products(Model viewModel) {
		String categories = "mJackets";
		if(categories.equals("mJackets")){
			viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "jackets"));
			}
			else if(categories.equals("mShirts")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "shirts"));
				} 
			else if(categories.equals("mPants")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "pants"));
				} 
			else if(categories.equals("wShirts")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("womens", "shirts"));
				} 
			else if(categories.equals("wJackets")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("womens", "jackets"));
				} 
			else if(categories.equals("wPants")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("womens", "pants"));
				} 
			return "products.jsp";
			} 
}
	
