package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Disciplina;
import br.com.senac.repository.DisciplinaRepository;


@Service
public class DisciplinaService {
	
private DisciplinaRepository disciplinaRepo;
	
	public List<Disciplina> listaTodasDisciplinas(){
		return disciplinaRepo.findAll();
	}
	
	
	public Disciplina buscarPorId(Integer id) throws ObjectNotFoundException {
		Optional<Disciplina> disciplina = disciplinaRepo.findById(id);
		return disciplina.orElseThrow(() -> new ObjectNotFoundException (null,"Objeto não encontrado"));	
	}
	
	
	public Disciplina salvar (Disciplina disciplina) {
		
		return disciplinaRepo.save(disciplina);
	}
	
	
	public void excluir (Integer id) {
		
		disciplinaRepo.deleteById(id);
	}
	
	
	public Disciplina alterar (Disciplina objDisciplina) throws ObjectNotFoundException {
		
		Disciplina disciplina = buscarPorId(objDisciplina.getId());
		disciplina.setNome(objDisciplina.getNome());
		return salvar(disciplina);
	}

}
