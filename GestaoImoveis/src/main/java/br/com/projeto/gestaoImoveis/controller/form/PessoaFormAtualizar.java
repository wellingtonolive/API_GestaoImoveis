package br.com.projeto.gestaoImoveis.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projeto.gestaoImoveis.models.Genero;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;

public class PessoaFormAtualizar {
	
	@NotEmpty(message = "Não pode ser vazio ")
	@NotNull(message = "Não pode ser nulo")
	private String nome;
	@NotEmpty(message = "Não pode ser vazio ")
	@NotNull(message = "Não pode ser nulo")
	private String sobrenome;
	@NotEmpty(message = "Não pode ser vazio ")
	@NotNull(message = "Não pode ser nulo")
	private String cpf;
	@NotNull(message = "Não pode ser nulo")
	private Genero genero;
	@NotEmpty(message = "Não pode ser vazio ")
	@NotNull(message = "Não pode ser nulo")
	private String numTelefoneFixo;
	@NotEmpty(message = "Não pode ser vazio ")
	@NotNull(message = "Não pode ser nulo")
	private String numCelular;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getNumTelefoneFixo() {
		return numTelefoneFixo;
	}
	public void setNumTelefoneFixo(String numTelefoneFixo) {
		this.numTelefoneFixo = numTelefoneFixo;
	}
	public String getNumCelular() {
		return numCelular;
	}
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
	
	public Pessoas atualizar(Long id, PessoaRepository pessoaRepository) {
		Pessoas pessoa = pessoaRepository.getOne(id);
		pessoa.setNome(nome);
		pessoa.setSobrenome(sobrenome);
		pessoa.setCpf(cpf);
		pessoa.setGenero(genero);
		pessoa.setNumTelefoneFixo(numTelefoneFixo);
		pessoa.setNumCelular(numCelular);
		return pessoa;
	}
	
	
	
	

}
