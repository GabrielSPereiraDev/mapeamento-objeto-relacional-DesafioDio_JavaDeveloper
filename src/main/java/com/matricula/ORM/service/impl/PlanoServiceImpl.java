package com.matricula.ORM.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.matricula.ORM.entity.Plano;
import com.matricula.ORM.repository.PlanoRepository;
import com.matricula.ORM.service.PlanoService;

/*
 * Implementação concreta de PlanoService usa o padrão Strategy e usa o padrão Facade.
 * 
 * 
 * */
@Service
public class PlanoServiceImpl implements PlanoService {
	
	private final PlanoRepository planoRepository; 
	
	// Injeção de dependência via construtor
	public PlanoServiceImpl(PlanoRepository planoRepository) { 
		this.planoRepository = planoRepository; 
		} 
	@Override 
	
	public Iterable<Plano> buscarTodos() { 
		
		return planoRepository.findAll(); 
		
	} 
	@Override 
	public Plano buscarPorId(Long id) { 
		
		return planoRepository.findById(id) .orElseThrow(() -> 
		new NoSuchElementException("Plano não encontrado com o ID: " + id)); 
		
	} 
	@Override 
	public void inserir(Plano plano) { 
		
		planoRepository.save(plano); 
		
	}
	@Override public void atualizar(Long id, Plano plano) { 
		
		if (!planoRepository.existsById(id)) { 
			
			throw new NoSuchElementException("Não é possível atualizar. Plano não encontrado com o ID: " + id); 
			
		} 
		
		plano.setId(id); 
		planoRepository.save(plano); 
		
	} 
	
	@Override public void deletar(Long id) { 
		
		//Usando existsById do CrudRepository do spring
		if (!planoRepository.existsById(id)) { 
			
			throw new NoSuchElementException("Não é possível deletar. Plano não encontrado com o ID: " + id); 
			
		} planoRepository.deleteById(id); 
		
	} 
	
}


