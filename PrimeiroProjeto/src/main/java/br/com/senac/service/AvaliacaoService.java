package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Avaliacao;
import br.com.senac.repository.AvaliacaoRepository;


@Service
public class AvaliacaoService {
	
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepo;

	

	public Avaliacao save(Avaliacao avaliacao) {	
		return avaliacaoRepo.save(avaliacao);
	}
	
	
	public List<Avaliacao> findAll(){
		return avaliacaoRepo.findAll();
	}
	

}
