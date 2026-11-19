package com.matricula.ORM.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Data reúne os recursos de @ToString, 
 * @EqualsAndHashCode, @Getter/@Setter e @RequiredArgsConstructor
 * 
 * @Entity informa ao Spring que a classe é uma entidade e 
 * vai persistir no BD formando uma tabela
 * */

@Data
@Entity
//Construtor vazio exigido pelo hibernate
@NoArgsConstructor
//Construtor padrão
@AllArgsConstructor
//A classe está mapeada para a tabela Tb_Aluno
@Table(name = "Tb_Aluno")
public class Aluno {
	
	
	//Chave primária da tabela, autogerada com `IDENTITY`
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
    private String cpf;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String telefone;
	
	//@ManyToOne representa o objeto a qual Aluno pertence
	@ManyToOne
	private Plano plano;
	
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
