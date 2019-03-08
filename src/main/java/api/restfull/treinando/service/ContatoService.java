package api.restfull.treinando.service;

import java.util.List;
import java.util.Optional;

import api.restfull.treinando.model.Contato;

public interface ContatoService {

	public List<Contato> findAll();
	
	public Optional<Contato> find(Long id);
	
	public Contato create(Contato contato);
	
	public Contato update(Long id, Contato contato);
	
	public Contato delete(Long id);
	
}
