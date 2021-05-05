package ru.currency.converter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GreetingController {

	@GetMapping()
	public String redirect() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(@RequestParam(name = "name", required = false, defaultValue = "greeting") String name,
			Model model) {
		model.addAttribute("name", name);

		return "index";
	}
	
	@RequestMapping(path = "/convert", method = RequestMethod.GET)
	public String convert(
			@RequestParam(name = "leftCurrency", required = true, defaultValue = "RUB") String leftCurrency,
			@RequestParam(name = "value", required = true) Double value,
			@RequestParam(name = "rightCurrency", required = true, defaultValue = "USD") String rightCurrency,
			Model model) {
		
		
		if (value <= 0) {
			value = Double.valueOf(0);
		}
		
		model.addAttribute("value", value * 1.5);
		return "index";
	}
	
	 
}
