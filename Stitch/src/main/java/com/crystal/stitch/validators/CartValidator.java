package com.crystal.stitch.validators;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public class CartValidator {
@Autowired
private WJService wjService;
	
	
	
	
	@GetMapping("/womens/jackets")
	private String wJackets(@ModelAttribute("wjacket") WJacket wJacket,  Model viewModel, HttpSession session) {
		List<WJacket> allWJackets = this.wjService.getAllWJackets();
		viewModel.addAttribute("wJackets", this.wjService.getAllWJackets());
		return "wjacket.jsp";
	}
	
	@GetMapping("/womens/jackets/{id}")
	public String showWJacket(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		WJacket wJacketDisplay = this.wjService.getSingleWJacket(id);
		viewModel.addAttribute("wJacket", showWJacket);
		return "showWJacket.jsp";
	}
}
