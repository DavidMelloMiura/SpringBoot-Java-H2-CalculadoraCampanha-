package com.calculadora.CalculadoraCampanha.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Campanha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String anuncio;

	private String nome;

	private float investimento;

	private String dataini;

	private String datafim;

	private int dias;

	private float total;

	private float views;

// ========== GETTERS E SETTERS ==========

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getInvestimento() {
		return investimento;
	}

	public void setInvestimento(float investimento) {
		this.investimento = investimento;
	}

	public String getDataini() {
		return dataini;
	}

	public void setDataini(String dataini) {
		this.dataini = dataini;
	}

	public String getDatafim() {
		return datafim;
	}

	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getViews() {
		return views;
	}

	public void setViews(float views) {
		this.views = views;
	}

//	DecimalFormat df = new DecimalFormat("0.00");

// ========== CALCULOS ==========

	public float CalcDias() {

		LocalDate ini = LocalDate.parse(dataini);
		LocalDate fim = LocalDate.parse(datafim);

		int dias = (int) ChronoUnit.DAYS.between(ini, fim);
		return dias;
	}

	public float ValorTotal() {

		total = CalcDias() * investimento;
		return total;
	}



	public double CalcView() {

		double custview = 0.03;
		double quantviews = ValorTotal() / custview;
		return Math.round(quantviews);
	}

	public double CalcClicks() {

		double quantclicks = (CalcView() / 100) * 12;
		return Math.round(quantclicks);
	}

	public double CalcShare() {

		double cont = 0;
		double compart = 0;

		for (cont = CalcClicks(); cont >= 20; compart++) {
			cont = cont - 20;
		}

		return Math.round(compart);
	}

	public double Calcviewstotal() {

		double newviews = CalcShare() * 40;
		double viewstotal = CalcView() + newviews;

		return Math.round(viewstotal);
	}

}
