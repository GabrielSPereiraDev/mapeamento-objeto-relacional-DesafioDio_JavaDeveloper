package com.matricula.ORM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matricula.ORM.entity.Plano;
/*
 * declara um método de consulta customizado derivado por nome 
 * 
 * */
public interface PlanoRepository extends JpaRepository<Plano, Long>{
	
	Optional<Plano> findByNomePlano(String nomePlano);

}
