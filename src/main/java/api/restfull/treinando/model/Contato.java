package api.restfull.treinando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="contatos")
public class Contato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O campo 'nome' não pode estar em branco.")
	@NotNull(message="O campo 'nome' não pode ser nulo.")
	private String nome;
	
	@NotBlank(message="O campo 'telefone' não pode estar em branco.")
	@NotNull(message="O campo 'telefone' não pode ser nulo.")
	@Size(min=8, message="Valor abaixo do esperado. O campo 'telefone' deverá conter entre 8 a 11 caracteres.")
	@Size(max=11, message="Valor excedido. O campo 'telefone' deverá conter entre 8 a 11 caracteres.")
	private String telefone;

	public Contato() {}
	
	public Contato(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "{id:"+this.id+", nome: "+this.nome+", telefone"+this.telefone+"}";
	}
	
}
