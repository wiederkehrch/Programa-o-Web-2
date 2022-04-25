package br.com.senac.resource;

import java.net.URI;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senac.constantes.Messages;
import br.com.senac.entity.Disciplina;
import br.com.senac.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = Messages.SWAGGER_TAG_DISCIPLINA_ENDPOINT)
@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> listarDisciplina(){
		List<Disciplina> disciplinas = disciplinaService.listaTodasDisciplinas();
		return ResponseEntity.ok().body(disciplinas);
	}
	
	
	@Operation(description = Messages.SWAGGER_GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Disciplina> buscaPorId(@PathVariable Integer id) throws ObjectNotFoundException{
		Disciplina disciplina = disciplinaService.buscarPorId(id);
		return ResponseEntity.ok().body(disciplina);
	}
	
	
	@Operation(description = Messages.SWAGGER_INSERT)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Disciplina objDisciplina){
		Disciplina disciplina = disciplinaService.salvar(objDisciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplina.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		disciplinaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@Operation(description = Messages.SWAGGER_UPDATE)
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Disciplina objDisciplina, @PathVariable Integer id){
		objDisciplina.setId(id);
		disciplinaService.alterar(objDisciplina);
		return ResponseEntity.noContent().build();
	}


}
