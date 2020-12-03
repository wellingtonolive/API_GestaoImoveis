package br.com.projeto.gestaoImoveis.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.gestaoImoveis.controller.dto.EnderecoDto;
import br.com.projeto.gestaoImoveis.controller.form.EnderecoForm;
import br.com.projeto.gestaoImoveis.controller.form.EnderecoFormAtualizar;
import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.respository.EnderecoRepository;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EnderecoForm enderecoForm,
			UriComponentsBuilder uriBUBuilder) {

		Optional<Pessoas> pessoa = pessoaRepository.findById(enderecoForm.getIdPessoa());
		if (!pessoa.isPresent()) {
			return ResponseEntity.badRequest().body("Pessoa não cadastrada no Sistema");
		}

		Endereco endereco = enderecoForm.converter(pessoa);
		enderecoRepository.save(endereco);

		URI uri = uriBUBuilder.path("/endereco/{id}").buildAndExpand(endereco.getID()).toUri();

		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(Long idPessoa, @RequestBody @Valid EnderecoFormAtualizar enderecoFormAtualizar){
		
		Optional<Pessoas> pessoa = pessoaRepository.findById(idPessoa);
		Optional<Endereco> enderecoPorIDAndCep = enderecoRepository.findByIDAndCep(enderecoFormAtualizar.getIdEndereco(), enderecoFormAtualizar.getCep());
		if(pessoa.isPresent() && enderecoPorIDAndCep.isPresent()) {
			Endereco endereco = enderecoFormAtualizar.atualizar(idPessoa,enderecoRepository);
			return ResponseEntity.ok(new EnderecoDto(endereco));
			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{idEndereco}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long idEndereco){
		Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);
		if(endereco.isPresent()) {
			enderecoRepository.delete(endereco.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().body("Endereço não cadastrado no Sistema");
	}
	

}
