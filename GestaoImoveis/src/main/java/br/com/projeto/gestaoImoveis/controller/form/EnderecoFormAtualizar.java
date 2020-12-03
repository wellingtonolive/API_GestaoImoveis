package br.com.projeto.gestaoImoveis.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.respository.EnderecoRepository;

public class EnderecoFormAtualizar {

	@NotNull(message = "Não pode ser nulo")
	private Long idEndereco;
	@NotNull(message = "Não pode ser nulo")
	@NotEmpty(message = "Não pode ser vazio")
	private String logradouro;
	@NotNull(message = "Não pode ser nulo")
	@NotEmpty(message = "Não pode ser vazio")
	private String numero;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String complemento;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String cep;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String cidade;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String estado;


	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
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

	public Endereco atualizar(Long idEnderecoPessoa, EnderecoRepository enderecoRepository) {
		
		Endereco endereco = enderecoRepository.getOne(this.idEndereco);
		
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		
		return endereco;
		
	}

}
