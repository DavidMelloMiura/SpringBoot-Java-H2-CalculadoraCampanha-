package com.calculadora.CalculadoraCampanha.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.calculadora.CalculadoraCampanha.CampanhaServico;
import com.calculadora.CalculadoraCampanha.Entity.Campanha;

@Controller
public class CampanhaController {
	
	@Autowired
	private CampanhaServico servico;
	
	@GetMapping("/campanhas")
	public ModelAndView getCampanhas() {
		
		ModelAndView mv = new ModelAndView("campanhas");
		mv.addObject("campanhas", servico.getCampanhas());
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Campanha campanha) {
		servico.salvar(campanha);
		return "redirect:/campanhas";
	}

}
