package com.crystal.stitch.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crystal.stitch.models.Feedback;

import com.crystal.stitch.services.FeedbackService;


@Controller
public class WebsiteController {

	@Autowired
	private FeedbackService fService;	
	
	@GetMapping("/")
	public String displayLanding() {
		return "index.jsp";
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
	
	
}

