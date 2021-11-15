package com.crystal.stitch.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StripePaymentController {

	@Value("${stripe.apikey}")
	String stripeKey;
	
	@GetMapping("/payment")
	public String payment() {
		System.out.println("Stripe Key: " + stripeKey);
		return "payment.jsp";
	}	
	
}
