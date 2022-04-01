package br.com.senac.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4332788980930201637L;


	//Declarações de atributos
	
	
	//Chave primária
	@Id
	@Column (name = "id_aluno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;



	@Column (name = "nome_aluno")
	private String nome;
	
	
	@ManyToOne //Vários alunos estão matriculados em uma mesma turma. Alunos não podem estar matriculados em mais de uma turma.
	@JoinColumn(name = "id_turma")
	@JsonIgnore
	private Turma turma;
	
	
	@ManyToMany //Vários alunos estão matriculados em várias disciplinas
	@JoinTable(
			name = "matricula",
			joinColumns = {@JoinColumn(name = "id_aluno")},
			inverseJoinColumns = {@JoinColumn(name = "id_disciplina")})
	private List<Disciplina> disciplinas;


	
	//Getters & Setters
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}

