package br.com.senac.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/*Para fazer a tabela Avaliação será necessário relacionar as tabelas 
  Aluno (id_aluno) e Disciplina (id_disciplina) -> chave composta */

@Embeddable
public class AlunoDisciplina {
	
	
	@ManyToOne
	private Aluno aluno;
	
	
	@ManyToOne
	private Disciplina disciplina;

	
	
	//Getters & Setters
	
	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}



}
