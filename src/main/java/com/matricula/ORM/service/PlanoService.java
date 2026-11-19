package com.matricula.ORM.service;


import com.matricula.ORM.entity.Plano;

/*A interface PlanoService define o contrato padrão para as operações do sistema
 * 
 * */
public interface PlanoService {
	
	Iterable<Plano> buscarTodos();

	Plano buscarPorId(Long id);

	void inserir(Plano plano);

	void atualizar(Long id, Plano plano);

	void deletar(Long id);

}
