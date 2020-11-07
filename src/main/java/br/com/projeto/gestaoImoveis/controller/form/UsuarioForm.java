package br.com.projeto.gestaoImoveis.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projeto.gestaoImoveis.models.Usuario;

public class UsuarioForm {

	@NotEmpty @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String nm_usuario;
	@NotNull @NotEmpty
	private String nm_senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

	public String getNm_senha() {
		return nm_senha;
	}

	public void setNm_senha(String nm_senha) {
		this.nm_senha = nm_senha;
	}

	public Usuario converter() {
		return new Usuario(nm_usuario, nm_senha, email);
	}

}
