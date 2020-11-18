package br.com.projeto.gestaoImoveis.controller.form;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.projeto.gestaoImoveis.models.Usuario;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;

public class UsuarioForm {

	@NotEmpty(message = "E-mail não pode ser vazio")
	@NotNull(message = "E-mail não pode ser nulo")
	@Email
	private String email;
	@NotNull(message = "Usuário não poder ser nulo")
	@NotEmpty(message = "Usuário não pode ser vazio")
	@Size(min = 5, message = "Usuário deve conter no mínimo 5 dígitos")
	private String nmUsuario;
	@NotNull(message = "Senha não pode ser nula")
	@NotEmpty(message = "Senha não poder ser vazia")
	@Size(min = 8, message = "Senha deve conter no mínimo 8 dígitos")
	private String nmSenha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNm_usuario() {
		return nmUsuario;
	}

	public void setNm_usuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getNm_senha() {
		return nmSenha;
	}

	public void setNm_senha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public Usuario converter() {
		
		return new Usuario(nmUsuario, new BCryptPasswordEncoder().encode(nmSenha), email);
	}

	public boolean validaUserEmail(UsuarioRepository usuarioRepository) {

		Optional<Usuario> usuarioPorUser = usuarioRepository.findByNmUsuario(nmUsuario);
		Optional<Usuario> usuarioPorEmail = usuarioRepository.findByEmail(email);

		if (usuarioPorUser.isPresent() || usuarioPorEmail.isPresent()) {
			return true;
		}

		return false;

	}

	public String apresentacao() {
		return "Olá \n Cadastro de Usuário Realizado com Sucesso \n" + "\nSegue Abaixo os Dados de Acesso.\n"
				+ "E-mail: " + this.email + " \n"  
				+ "Usuário: " + this.nmUsuario + "\n"
				+ "Guarde bem essas informações, serão usadadas para Acessar nossa Plataforma.\n"
				+ "\nNo seu Primeiro Acesso, não esqueça de Completar o seu perfil, com suas informações pessoais\n";

	}

}
