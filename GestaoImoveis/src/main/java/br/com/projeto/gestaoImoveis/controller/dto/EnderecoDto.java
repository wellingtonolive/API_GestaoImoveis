package br.com.projeto.gestaoImoveis.controller.dto;

import br.com.projeto.gestaoImoveis.models.Endereco;

public class EnderecoDto {

	
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	
	public Long getId() {
		return id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public EnderecoDto(Endereco endereco) {
		this.id = endereco.getID();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
	}

}
