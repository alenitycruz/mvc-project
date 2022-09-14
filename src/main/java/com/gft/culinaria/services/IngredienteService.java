package com.gft.culinaria.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.culinaria.entities.Ingrediente;
import com.gft.culinaria.repositories.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente salvarIngrediente(Ingrediente ingrediente) {
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
	    String strDate = sdfDate.format(now);
		
		ingrediente.setDtAtualizacao(strDate);
		
		return ingredienteRepository.save(ingrediente);
	}
	
	public List<Ingrediente> listarIngrediente(){
		return ingredienteRepository.findAll();
	}
	
	
	public Ingrediente obterIngrediente(Long cadastro) throws Exception {
		
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(cadastro);
		
		if(ingrediente.isEmpty()) {
			throw new Exception("Ingrediente não encontrado.");

		}
		
		return ingrediente.get();
		
	}

	public void excluirIngrediente(Long cadastro) {
		ingredienteRepository.deleteById(cadastro);
	}
	
	
	
	
	
}
