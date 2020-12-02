package br.com.projeto.gestaoImoveis.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.models.Usuario;

public class PessoaDTO {

	private Long ID;
	private String user;
	private String nome;
	

	public Long getID() {
		return ID;
	}

	public String getUser() {
		return user;
	}

	public String getNome() {
		return nome;
	}

	
	public PessoaDTO(Long iD, Usuario user, String nome) {
		ID = iD;
		this.user = user.getNmusuario();
		this.nome = nome;
	}

	public PessoaDTO(Pessoas pessoa) {
		this.nome = pessoa.getNome();
		this.ID = pessoa.getID();
		this.user = pessoa.getUser().getNmusuario();
		
	}

	public static List<PessoaDTO> converter(List<Pessoas> lista) {
		return lista.stream().map(PessoaDTO :: new).collect(Collectors.toList());
	}

}
