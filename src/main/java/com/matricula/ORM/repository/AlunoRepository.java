package com.matricula.ORM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matricula.ORM.entity.Aluno;

/*
 * Está sendo herdado de JpaRepository vários métodos CRUD básicos 
 * 
 * 
 * */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
