package br.com.projeto.gestaoImoveis.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Pessoas;

public class EnderecoForm {

	@NotNull(message = "Não pode ser nulo")
	private Long idPessoa;
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

	public Long getIdPessoa() {
		return idPessoa;
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

	public Endereco converter(Optional<Pessoas> pessoa) {

		return new Endereco(pessoa.get(), this.logradouro, this.numero, this.complemento, this.cep, this.cidade,
				this.estado);
	}

}
