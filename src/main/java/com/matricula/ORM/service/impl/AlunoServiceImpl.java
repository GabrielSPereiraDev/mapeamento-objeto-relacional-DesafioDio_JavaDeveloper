package com.matricula.ORM.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.matricula.ORM.entity.Aluno;
import com.matricula.ORM.entity.Plano;
import com.matricula.ORM.repository.AlunoRepository;
import com.matricula.ORM.repository.PlanoRepository;
import com.matricula.ORM.service.AlunoService;

/*
 * Implementação concreta de AlunoService usa o padrão Strategy ao 
 * implementar os métodos definidos na interface e usa o padrão Facade ao 
 * abstrair integrações com subsistemas, provendo uma interface simples.
 * 
 * 
 * */
@Service
public class AlunoServiceImpl implements AlunoService {
	
	// TODO criar enums para padronizar os planos
	private static final String PLANO_PADRAO_NOME = "Plano Padrão"; 
	
	private final AlunoRepository alunoRepository; 
	
	private final PlanoRepository planoRepository; 
		
		
		// Injeção via construtor 
		public AlunoServiceImpl(AlunoRepository alunoRepository, 
				PlanoRepository planoRepository) { 
			
			this.alunoRepository = alunoRepository; 
			this.planoRepository = planoRepository; 
			
		} 
		
		@Override 
		public Iterable<Aluno> buscarTodos() { 
			
			return alunoRepository.findAll(); 
			
		} 
		
		@Override 
		public Aluno buscarPorId(Long id) { 
			
			return alunoRepository.findById(id) .orElseThrow(() -> 
			
			new NoSuchElementException("Aluno não encontrado com o ID: " + id)); 
			
		} 
		
		@Override 
		public void inserir(Aluno aluno) { 
			
			salvarAlunoComPlano(aluno); 
			
		} 
		
		@Override 
		public void atualizar(Long id, 
				Aluno aluno) { 
			
			// Lança exceção se o aluno não existir no banco de dados 
			if (!alunoRepository.existsById(id)) { 
				
				throw new NoSuchElementException("Não foi possível atualizar. Aluno não encontrado com o ID: " + id); 
				
			} 
			
			aluno.setId(id);
			salvarAlunoComPlano(aluno); 
			
		} 
		
		@Override 
		public void deletar(Long id) { 
			
			// Valida a existência do registro antes de excluir 
			
			if (!alunoRepository.existsById(id)) { 
				
				throw new NoSuchElementException("Não foi possível deletar. Aluno não encontrado com o ID: " + id); 
				
			} 
			
			alunoRepository.deleteById(id); 
			
		} private void salvarAlunoComPlano(Aluno aluno) { 
			
			Plano planoFinal = null; 
			
			if (aluno.getPlano() != null) { 
				
				// Tentar localizar o plano pelo ID se for fornecido 
				if (aluno.getPlano().getId() != null) { 
					
					planoFinal = planoRepository.findById(aluno.getPlano().getId()).orElse(null); 
					
				} // Se não encontrou por ID, tenta buscar pelo nome do plano 
				
				if (planoFinal == null && aluno.getPlano().getNomePlano() != null && !aluno.getPlano().getNomePlano().isBlank()) { 
					
					planoFinal = planoRepository.findByNomePlano(aluno.getPlano().getNomePlano()).orElse(null); 
					
				} 
				
			} 
			
			// Se nenhum plano válido for encontrado, vincula o plano padrão 
			
			if (planoFinal == null) { 
				
				planoFinal = obterOuCriarPlanoPadrao(); 
			
			} 
			
			aluno.setPlano(planoFinal); 
			alunoRepository.save(aluno); 
			
		} 
		
		private Plano obterOuCriarPlanoPadrao() { 
			
			return planoRepository.findByNomePlano(PLANO_PADRAO_NOME) .orElseGet(() -> { 
				
				Plano novoPlano = new Plano(); 
				novoPlano.setNomePlano(PLANO_PADRAO_NOME); 
				novoPlano.setMensalidade("0.00");
				
				return planoRepository.save(novoPlano); }); 
			
		} 
		

			

}
		
		

				
		
		
	

	


