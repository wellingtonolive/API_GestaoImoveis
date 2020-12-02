package br.com.projeto.gestaoImoveis.controller;

import java.net.URI;
import java.text.ParseException;
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

import br.com.projeto.gestaoImoveis.controller.dto.DetalhePessoaDTO;
import br.com.projeto.gestaoImoveis.controller.dto.PessoaDTO;
import br.com.projeto.gestaoImoveis.controller.form.PessoaForm;
import br.com.projeto.gestaoImoveis.controller.form.PessoaFormAtualizar;
import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.respository.EnderecoRepository;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;
import io.swagger.annotations.Api;

@Api(value = "Pessoas")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder uriBUBuilder)
			throws ParseException {

		if (pessoaForm.validaPessoaPorCPF(pessoaRepository)) {
			return ResponseEntity.badRequest().body("Pessoa já cadastrada no Sistema");
		}

		Pessoas pessoa = pessoaForm.converterPessoa(usuarioRepository);
		pessoaRepository.save(pessoa);

		URI uri = uriBUBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getID()).toUri();

		return ResponseEntity.created(uri).body(new PessoaDTO(pessoa));

	}

	@GetMapping
	@Transactional
	public List<PessoaDTO> lista() {

		List<Pessoas> lista = pessoaRepository.findAll();

		return PessoaDTO.converter(lista);

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalhePessoaDTO> detalhePessoa(@PathVariable Long id) {

		Optional<Pessoas> pessoa = pessoaRepository.findById(id);
		List<Endereco> endereco = enderecoRepository.findByPessoaID(id);
		return pessoa.isPresent() ? ResponseEntity.ok(new DetalhePessoaDTO(pessoa, endereco))
				: ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalhePessoaDTO> atualizar(@RequestBody @Valid PessoaFormAtualizar pessoaFomrmAtualizar,
			@PathVariable Long id) {

		Optional<Pessoas> pessoas = pessoaRepository.findById(id);
		if (pessoas.isPresent()) {
			Pessoas pessoa = pessoaFomrmAtualizar.atualizar(id, pessoaRepository);
			return ResponseEntity.ok(new DetalhePessoaDTO(pessoa));
		}
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id){
		
		Optional<Pessoas> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
