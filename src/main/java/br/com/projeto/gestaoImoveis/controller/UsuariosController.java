package br.com.projeto.gestaoImoveis.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.gestaoImoveis.controller.dto.UsuarioDto;
import br.com.projeto.gestaoImoveis.controller.form.UsuarioForm;
import br.com.projeto.gestaoImoveis.models.Usuario;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<UsuarioDto> lista() {

		List<Usuario> usuarios = usuarioRepository.findAll();

		return UsuarioDto.converter(usuarios);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm,
			UriComponentsBuilder uriBUBuilder) {
		
		if(usuarioForm.validaUserEmail(usuarioRepository)) {
			return ResponseEntity.badRequest().body("Usuário e/ou E-mail já cadastrado no Sistema.");
		}
		
		Usuario usuario = usuarioForm.converter();
		usuarioRepository.save(usuario);

		URI uri = uriBUBuilder.path("/usuario/{id}").buildAndExpand(usuario.getID()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

}
