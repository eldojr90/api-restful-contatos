package api.restfull.treinando.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.restfull.treinando.model.Contato;
import api.restfull.treinando.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService {

	private ContatoRepository repository;
	
	public ContatoServiceImpl(ContatoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Contato> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Contato> find(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Contato create(Contato contato) {
		this.repository.save(contato);
		return contato;
	}

	@Override
	public Contato update(Long id, Contato contato) {
		Optional<Contato> contatoExiste = this.repository.findById(id);
		Contato contatoPesquisado = null;
		
		if(contatoExiste.isPresent()) {
			contatoPesquisado = contatoExiste.get();
			contato.setId(contatoPesquisado.getId());
			this.repository.save(contato);
			return contato;
		}
		
		return null;
	}

	@Override
	public Contato delete(Long id) {
		Optional<Contato> contatoOpt = this.repository.findById(id);
		Contato contatoPesquisado = null;
		
		if(contatoOpt.isPresent()) {
			contatoPesquisado = contatoOpt.get();
			this.repository.delete(contatoPesquisado);
		}
			
		return contatoPesquisado;
	}
	
}
