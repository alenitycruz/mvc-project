package com.gft.culinaria.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cadastro;
	
	@NotEmpty(message = "Ingrediente não pode ser vazio")
	private String nome;
	
	private String dtAtualizacao;
	
	@OneToMany(mappedBy = "ingrediente")
	private List<Receita> receita;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(String dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}


	public void setCadastro(Long cadastro) {
		this.cadastro = cadastro;
	}

	public Long getCadastro() {
		return cadastro;
	}

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

	
	
	
	
	

}
