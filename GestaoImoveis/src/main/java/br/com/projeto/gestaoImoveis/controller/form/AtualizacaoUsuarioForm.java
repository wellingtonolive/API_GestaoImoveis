package br.com.projeto.gestaoImoveis.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.projeto.gestaoImoveis.models.Usuario;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotNull(message = "Senha não pode ser nula")
	@NotEmpty(message = "Senha não poder ser vazia")
	@Size(min = 8, message = "Senha deve conter no mínimo 8 dígitos")
	private String nmSenha;

	public String getNmSenha() {
		return nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setSenha(new BCryptPasswordEncoder().encode(this.nmSenha));
		
		return usuario;
		
	}
	
	

}
