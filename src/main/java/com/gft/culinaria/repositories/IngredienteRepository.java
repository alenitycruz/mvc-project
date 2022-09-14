package com.gft.culinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.culinaria.entities.Ingrediente;

@Repository 
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
