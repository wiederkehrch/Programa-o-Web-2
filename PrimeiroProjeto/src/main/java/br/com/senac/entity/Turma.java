package br.com.senac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5702987693051928939L;
	
	
	//Declarações de atributos
	
	
	//Chave primária
	@Id
	@Column (name = "id_turma")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column (name = "nome_turma")
	private String nome;

	
	//private List<Aluno> listaAlunos = new ArrayList<>();

	
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
	
	
	

}
