package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.entity.Disciplina;


public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
