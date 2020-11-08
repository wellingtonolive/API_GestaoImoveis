package br.com.projeto.gestaoImoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nmUsuario;
	private String senha;
	private String email;

	public Usuario() {

	}

	public Usuario(String nmUsuario, String senha, String email) {
		this.nmUsuario = nmUsuario;
		this.senha = senha;
		this.email = email;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNmusuario() {
		return nmUsuario;
	}

	public void setNmusuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
