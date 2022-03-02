package com.calculadora.CalculadoraCampanha.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calculadora.CalculadoraCampanha.Entity.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long>{

}
