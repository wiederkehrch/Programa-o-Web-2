package br.com.senac.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senac.constantes.Messages;
import br.com.senac.entity.Avaliacao;
import br.com.senac.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = Messages.SWAGGER_TAG_AVALIACAO_ENDPOINT)
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> listarAvaliacao(){
		List<Avaliacao> listaAvaliacao = avaliacaoService.findAll();
		return ResponseEntity.ok().body(listaAvaliacao);
	}
	
	
	@Operation(description = Messages.SWAGGER_INSERT)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Avaliacao objAvaliacao){
		Avaliacao avaliacao = avaliacaoService.save(objAvaliacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacao.getAlunoDisciplina()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
