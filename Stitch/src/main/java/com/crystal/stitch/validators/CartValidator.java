// package com.crystal.stitch.validators;

// import java.util.List;

// import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import com.crystal.stitch.models.Product;
// import com.crystal.stitch.services.ProductService;

// public class CartValidator {
// <<<<<<< terra
// //@Autowired
// //private WJService wjService;
// //	
// //	
// //	
// //	
// //	@GetMapping("/womens/jackets")
// //	private String wJackets(@ModelAttribute("wjacket") WJacket wJacket,  Model viewModel, HttpSession session) {
// //		List<WJacket> allWJackets = this.wjService.getAllWJackets();
// //		viewModel.addAttribute("wJackets", this.wjService.getAllWJackets());
// //		return "wjacket.jsp";
// //	}
// //	
// //	@GetMapping("/womens/jackets/{id}")
// //	public String showWJacket(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
// //		WJacket wJacketDisplay = this.wjService.getSingleWJacket(id);
// //		viewModel.addAttribute("wJacket", showWJacket);
// //		return "showWJacket.jsp";
// //	}
// =======
// @Autowired
// private ProductService pService;
	
	
	
	
// 	@GetMapping("/womens/jackets")
// 	private String wJackets(Model viewModel, HttpSession session) {
// 		List<Product> allProducts = this.pService.getAllProducts();
// 		viewModel.addAttribute("products", allProducts);
// 		return "wjacket.jsp";
// 	}
	
// 	@GetMapping("/womens/jackets/{id}")
// 	public String showWJacket(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
// 		Product productDisplay = this.pService.getSingleProduct(id);
// 		viewModel.addAttribute("product", productDisplay);
// 		return "showWJacket.jsp";
// 	}
// >>>>>>> main
// }
