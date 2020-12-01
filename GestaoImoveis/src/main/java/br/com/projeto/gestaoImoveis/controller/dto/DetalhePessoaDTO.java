package br.com.projeto.gestaoImoveis.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.projeto.gestaoImoveis.config.Utils;
import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Pessoas;

public class DetalhePessoaDTO {

	private Long ID;
	private String user;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String dtNascimento;
	private String genero;
	private String numTelefoneFixo;
	private String numCelular;
	private String perfilUsuario;
	private List<EnderecoDto> endereco = new ArrayList<EnderecoDto>();

	public Long getID() {
		return ID;
	}

	public String getUser() {
		return user;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public String getNumTelefoneFixo() {
		return numTelefoneFixo;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public String getPerfilUsuario() {
		return perfilUsuario;
	}

	public List<EnderecoDto> getListaEndereco() {
		return endereco;
	}

	public DetalhePessoaDTO(Long iD, String user, String nome, String sobrenome, String cpf, String dtNascimento,
			String genero, String numTelefoneFixo, String numCelular, String perfilUsuario,
			List<EnderecoDto> listaEndereco) {
		ID = iD;
		this.user = user;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
		this.numTelefoneFixo = numTelefoneFixo;
		this.numCelular = numCelular;
		this.perfilUsuario = perfilUsuario;
		this.endereco = listaEndereco;
	}

	public DetalhePessoaDTO(Pessoas pessoas) {
		this.ID = pessoas.getID();
		this.user = pessoas.getUser().getNmusuario();
		this.nome = pessoas.getNome();
		this.sobrenome = pessoas.getSobrenome();
		this.cpf = pessoas.getCpf();
		this.dtNascimento = Utils.converterDateEmStringFormatado(pessoas.getDtNascimento());
		// this.genero = pessoas.getGenero();
		this.numTelefoneFixo = pessoas.getNumTelefoneFixo();
		this.numCelular = pessoas.getNumCelular();

	}

	public DetalhePessoaDTO(Optional<Pessoas> pessoa, List<Endereco> listaEndereco) {

		this.ID = pessoa.get().getID();
		this.user = pessoa.get().getUser().getNmusuario();
		this.nome = pessoa.get().getNome();
		this.sobrenome = pessoa.get().getSobrenome();
		this.cpf = pessoa.get().getCpf();
		this.dtNascimento = Utils.converterDateEmStringFormatado(pessoa.get().getDtNascimento());
		// this.genero = pessoas.getGenero();
		this.numTelefoneFixo = pessoa.get().getNumTelefoneFixo();
		this.numCelular = pessoa.get().getNumCelular();
		listaEndereco.stream().forEach(endereco -> this.endereco.add(new EnderecoDto(endereco)));
	}

}
