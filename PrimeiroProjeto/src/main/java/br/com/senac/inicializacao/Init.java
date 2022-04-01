package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Disciplina;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.repository.DisciplinaRepository;
import br.com.senac.repository.TurmaRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@Autowired
	TurmaRepository turmaRepo;
	
	@Autowired
	DisciplinaRepository disciplinaRepo;
	
	
	@Override
	public void onApplicationEvent (ContextRefreshedEvent event) {
		
		
		//Cadastrando Alunos
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Joao");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Alberto");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Pedro");
		
		
		
		
		//Cadastrando Disciplinas
		Disciplina java = new Disciplina();
		java.setNome("JAVA I");
		
		Disciplina java2 = new Disciplina();
		java2.setNome("JAVA II");
		
		Disciplina arquitetura = new Disciplina();
		arquitetura.setNome("Arquitetura");
		
		
		//Salvando Disciplinas
		disciplinaRepo.saveAll(Arrays.asList(java, java2, arquitetura));
		
		
		//Cadastrando Turmas
		Turma ads = new Turma();
		ads.setNome("ADS");
		//ads.setListaAlunos(Arrays.asList(aluno1, aluno2));
		
		Turma rede = new Turma();
		rede.setNome("REDE");
		//rede.setListaAlunos(Arrays.asList(aluno3, aluno4));
		
		
		//Salvando Turmas
		turmaRepo.save(ads);
		turmaRepo.save(rede);

		
		//Relação Aluno-Turma
		aluno1.setTurma(ads);
		aluno2.setTurma(ads);
		aluno3.setTurma(rede);
		aluno4.setTurma(rede);
		
		
		//Relação Aluno-Disciplina
		aluno1.setDisciplinas(Arrays.asList(java, arquitetura));
		aluno2.setDisciplinas(Arrays.asList(java, java2));
		aluno3.setDisciplinas(Arrays.asList(java2, arquitetura));
		aluno4.setDisciplinas(Arrays.asList(java, arquitetura));

		
		//Salvando Alunos
		alunoRepo.save(aluno1);
		alunoRepo.save(aluno2);
		alunoRepo.save(aluno3);
		alunoRepo.save(aluno4);

		
		//Outra forma de salvar
		//alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
	}

}
