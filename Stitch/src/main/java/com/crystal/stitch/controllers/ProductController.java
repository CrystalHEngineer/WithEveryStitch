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


	@GetMapping("/{categories}")
	public String products(@PathVariable("categories") String categories, Model viewModel) {
		if(categories.equals("mJackets")){
			viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "jacket"));
			}
			else if(categories.equals("mShirts")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "shirt"));
				} 
			else if(categories.equals("mPants")) {
				viewModel.addAttribute("product", this.pService.getGenderAndItem("mens", "pants"));
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
			return "products.jsp";
			} 
}