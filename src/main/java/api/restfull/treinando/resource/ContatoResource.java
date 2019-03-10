package api.restfull.treinando.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.restfull.treinando.model.Contato;
import api.restfull.treinando.service.ContatoService;
import api.restfull.treinando.utils.Message;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	public ContatoResource(ContatoService service) {
		this.service = service;
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll() {
		List<Contato> contatos = this.service.findAll();
		return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> find(@PathVariable(value="id") Long id) {
			
		System.err.println("Id: "+id);
		Optional<Contato> findContato = this.service.find(id);
			
		if(findContato.isPresent()) {
			Contato contato = findContato.get();
			return ResponseEntity.ok().body(contato);
		}
			
		return Message.messageError(HttpStatus.NOT_FOUND, "id "+id+" inexistente");
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> create(@Valid @RequestBody Contato contato, Errors errors) {
		if(!errors.hasErrors()) {
			Contato contatoCreated = this.service.create(contato);
			return new ResponseEntity<Contato>(contatoCreated, HttpStatus.CREATED);
		}
		
		return Message.messageErrorDefault(errors);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable("id") Long id,
									@Valid @RequestBody Contato contato, 
									Errors errors) {
		
		if(!errors.hasErrors()) {
			Contato contatoUpdated = this.service.update(id, contato);
			
			if(contatoUpdated == null) {
				return ResponseEntity.notFound().build();
			}
			
			return new ResponseEntity<Contato>(contatoUpdated, HttpStatus.OK);
		}
		
		return Message.messageErrorDefault(errors);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		Contato contatoDelecao = this.service.delete(id);
		
		if(contatoDelecao != null) {
			return ResponseEntity.noContent().build();
		}
			
			return ResponseEntity.notFound().build();
	}
	
}
