package com.calculadora.CalculadoraCampanha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculadora.CalculadoraCampanha.Entity.Campanha;
import com.calculadora.CalculadoraCampanha.Repository.CampanhaRepository;



@Service
public class CampanhaServico {
	
//	INJEÇÃO DO REPOSITORIO
	@Autowired
	private CampanhaRepository repository;
	
//	METODO QUE DEVOLVE TODOS AS CAMPANHAS PARA O CONTROLADOR
	public List<Campanha> getCampanhas(){
		return repository.findAll();
	}
	
	public void salvar(Campanha campanha) {
		repository.save(campanha);
	}

}
