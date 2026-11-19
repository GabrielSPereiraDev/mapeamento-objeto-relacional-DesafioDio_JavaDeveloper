package com.matricula.ORM.service;



import com.matricula.ORM.entity.Aluno;
/*A interface AlunoService define o contrato padrão para as operações do sistema
 * 
 * */

public interface AlunoService {
	
	Iterable<Aluno> buscarTodos();

	Aluno buscarPorId(Long id);

	void inserir(Aluno aluno);

	void atualizar(Long id, Aluno aluno);

	void deletar(Long id);

}
