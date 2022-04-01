package br.com.senac.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

	
	//Chave composta - Aluno_Disciplina
	@EmbeddedId
	private AlunoDisciplina alunoDisciplina;
	
	private String conceito;

	
	
	//Getters & Setters
	
	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	


}
