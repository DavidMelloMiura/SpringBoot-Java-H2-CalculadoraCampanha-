package com.calculadora.CalculadoraCampanha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.calculadora.CalculadoraCampanha.Entity.Campanha;

@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {	
		return "index";	
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String index(Campanha campanha) {
		
		return "redirect:/cadastarCampanha";
		
	}

}
