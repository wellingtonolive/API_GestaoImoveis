package br.com.projeto.gestaoImoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@ManyToOne
	private Pessoas pessoa;
	@OneToOne
	private Imoveis imovel;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Endereco() {

	}

	public Endereco(Long iD, Pessoas pessoa, String logradouro, String numero, String complemento, String cep,
			String cidade, String estado) {
		ID = iD;
		this.pessoa = pessoa;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco(Pessoas pessoa, String logradouro, String numero, String complemento, String cep, String cidade,
			String estado) {
		this.pessoa = pessoa;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco(String logradouro, String numero, String complemento, String cep, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco(Imoveis imovel, String logradouro, String numero, String complemento, String cep, String cidade,
			String estado) {
		this.imovel = imovel;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	
	

}
