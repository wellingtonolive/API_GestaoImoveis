package br.com.projeto.gestaoImoveis.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.gestaoImoveis.config.email.EmailService;
import br.com.projeto.gestaoImoveis.controller.dto.UsuarioDto;
import br.com.projeto.gestaoImoveis.controller.dto.DetalharUsuarioDto;
import br.com.projeto.gestaoImoveis.controller.form.AtualizacaoUsuarioForm;
import br.com.projeto.gestaoImoveis.controller.form.UsuarioForm;
import br.com.projeto.gestaoImoveis.models.Usuario;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmailService emailService;

	@GetMapping
	public List<UsuarioDto> lista() {

		List<Usuario> usuarios = usuarioRepository.findAll();

		return UsuarioDto.converter(usuarios);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBUBuilder) {

		if (usuarioForm.validaUserEmail(usuarioRepository)) {
			return ResponseEntity.badRequest().body("Usuário e/ou E-mail já cadastrado no Sistema.");
		}

		Usuario usuario = usuarioForm.converter();
		usuarioRepository.save(usuario);
		URI uri = uriBUBuilder.path("/usuario/{id}").buildAndExpand(usuario.getID()).toUri();
		emailService.sendMail(usuarioForm.getEmail(), "Cadastro Realizado com Sucesso", usuarioForm.apresentacao());
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalharUsuarioDto> detalharUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new DetalharUsuarioDto(usuario.get()));
		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoUsuarioForm atualizaUsuarioForm) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuario = atualizaUsuarioForm.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}

		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		
		if(usuarioOptional.isPresent()) {
			usuarioRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		

	}

}
