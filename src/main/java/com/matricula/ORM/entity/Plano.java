package com.matricula.ORM.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Plano {
	
	//Chave primária da tabela, autogerada com `IDENTITY`
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String nomePlano; 

    @Column
    private String mensalidade;


    public Plano() {
    	
    }
    //Construtor
    public Plano(String nomePlano, String mensalidade) {
        this.nomePlano = nomePlano;
        this.mensalidade = mensalidade;
       
    }
    
    //@ManyToOne representa o objeto a qual Plano pertence
    @ManyToOne
	private Aluno aluno;

    public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}


	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(String mensalidade) {
		this.mensalidade = mensalidade;
	}
   
}


