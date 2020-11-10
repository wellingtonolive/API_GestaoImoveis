package br.com.projeto.gestaoImoveis.controller.dto;

import br.com.projeto.gestaoImoveis.models.Usuario;

public class DetalharUsuarioDto {

	private Long id;
	private String nmUsuario;
	private String email;
	private String nmSenha;

	public DetalharUsuarioDto(Usuario usuario) {
		this.id = usuario.getID();
		this.nmUsuario = usuario.getNmusuario();
		this.email = usuario.getEmail();
		this.nmSenha = usuario.getSenha();

	}

	public Long getId() {
		return id;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getNmSenha() {
		return nmSenha;
	}

}
