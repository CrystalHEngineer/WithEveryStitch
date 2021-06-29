package com.crystal.stitch.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crystal.stitch.models.Product;
import com.crystal.stitch.services.ProductService;
import com.crystal.stitch.services.UserService;
import com.crystal.stitch.validators.UserValidator;

public class ProductController {
	@Autowired 
	private ProductService pService;
	@Autowired
	private UserService uService;
	@Autowired 
	private UserValidator validator;
	
	@GetMapping("/womens/jackets")
	public String wjackets(Model viewModel, HttpSession session) {
		List<Product> products = pService.getAllProducts();
		viewModel.addAttribute("products", products);
		return "wjacket.jsp";
	}
}
