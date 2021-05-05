package ru.currency.converter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.currency.converter.entity.Converter;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import ru.currency.converter.entity.CurrencyParser;

@Controller
@RequestMapping("/")
public class GreetingController {
	
	@GetMapping()
	public String redirectToIndex() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {

		return "index";
	}
	
	@RequestMapping(path = "/convert", method = RequestMethod.GET)
	public String convert(@ModelAttribute("converter") @Valid Converter converter, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			converter.setValue(0.0);
		}
		
		double outputValue = converter.convert("https://www.cbr.ru/currency_base/daily/", "div.table", "tr");
		
		model.addAttribute("outputValue", outputValue);
		return "index";

	}
	
}
