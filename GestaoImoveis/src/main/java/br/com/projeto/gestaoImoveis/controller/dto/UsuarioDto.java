package br.com.projeto.gestaoImoveis.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projeto.gestaoImoveis.models.Usuario;

public class UsuarioDto {
	
	private Long id;
	private String nmUsuario;
	private String email;
	
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getID();
		this.nmUsuario = usuario.getNmusuario();
		this.email = usuario.getEmail();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getNm_usuario() {
		return nmUsuario;
	}
	public String getEmail() {
		return email;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto :: new).collect(Collectors.toList());
	}
	
	

}
