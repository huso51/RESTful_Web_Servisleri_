package com.mimaraslan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/merkez")
public class HomeController {

	@RequestMapping(value = "/detay/{adiSoyadi}/{sehir}/{email}", method = RequestMethod.GET)
	public String home(@PathVariable("adiSoyadi") String adiSoyadi, 
			@PathVariable("sehir") String sehir, 
			@PathVariable("email") String email, 
			
			Model model) {
		
	
		model.addAttribute("adiSoyadi", adiSoyadi );
		model.addAttribute("sehir", sehir );
		model.addAttribute("email", email );
		
		return "home";
	}
	
}
