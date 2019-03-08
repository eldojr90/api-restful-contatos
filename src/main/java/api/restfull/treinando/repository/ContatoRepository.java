package api.restfull.treinando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.restfull.treinando.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
}
