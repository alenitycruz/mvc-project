package com.gft.culinaria.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.culinaria.entities.Receita;
import com.gft.culinaria.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public Receita salvarReceita(Receita receita) {
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
	    String strDate = sdfDate.format(now);
		
		receita.setDtAtualizacao(strDate);
		
		return receitaRepository.save(receita);
	}
	
	public List<Receita> listarReceita() {
		return receitaRepository.findAll();
	}
	
	public Receita obterReceita(Long cadastro) throws Exception {
		Optional<Receita> receita = receitaRepository.findById(cadastro);
		
		if(receita.isEmpty()) {
			throw new Exception ("Receita não encontrada.");
		}
		return receita.get();
	}
	
	public void excluirReceita(Long cadastro) {
		receitaRepository.deleteById(cadastro);
	}

}
