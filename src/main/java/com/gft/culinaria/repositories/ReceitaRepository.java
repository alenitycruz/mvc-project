package com.gft.culinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.culinaria.entities.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
