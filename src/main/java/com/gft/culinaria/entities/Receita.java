package com.gft.culinaria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Receita {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cadastro;
	
	@NotEmpty(message = "Receita não pode ser vazio")
	private String nomeReceita;
	
	@ManyToOne
	private Ingrediente ingrediente;
	
	
	private String modoPreparo;
	
	private String tempoPreparo;

	private String dtAtualizacao;
	

	public Long getCadastro() {
		return cadastro;
	}

	public void setCadastro(Long cadastro) {
		this.cadastro = cadastro;
	}

	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(String tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public String getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(String dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	
	
	
	
}
