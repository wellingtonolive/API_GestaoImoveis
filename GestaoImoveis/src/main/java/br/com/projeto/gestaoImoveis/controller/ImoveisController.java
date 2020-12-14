package br.com.projeto.gestaoImoveis.controller;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.gestaoImoveis.controller.dto.DetalheImovelDTO;
import br.com.projeto.gestaoImoveis.controller.dto.ImoveisDTO;
import br.com.projeto.gestaoImoveis.controller.form.ImovelForm;
import br.com.projeto.gestaoImoveis.controller.form.ImovelFormAtualizar;
import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Imoveis;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.respository.EnderecoRepository;
import br.com.projeto.gestaoImoveis.respository.ImovelRepository;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;

@RestController
@RequestMapping("/imoveis")
public class ImoveisController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody ImovelForm imovelForm,UriComponentsBuilder uriBUBuilder) throws ParseException{
		
		if(!imovelForm.buscaPessoaPorCPF(pessoaRepository)) {
			return ResponseEntity.badRequest().body("Proprietário não cadastrado no Sistema");
		}
		
		Imoveis imovel = imovelForm.converterImovel(pessoaRepository);
		imovelRepository.save(imovel);
		
		Endereco endereco = imovelForm.converterEndereco(imovel);
		enderecoRepository.save(endereco);
		
		URI uri = uriBUBuilder.path("imovel/{id}").buildAndExpand(imovel.getID()).toUri();
		
		
		return ResponseEntity.created(uri).body(new ImoveisDTO(imovel));
	}
	
	
	@GetMapping
	@Transactional
	public List<ImoveisDTO> listar(){
		
		
		List<Imoveis> listaImoveis = imovelRepository.findAll();
		
		return ImoveisDTO.converter(listaImoveis);
		
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalheImovelDTO> detalharImovel(@PathVariable Long id){
		
		Optional<Imoveis> imovel = imovelRepository.findById(id);
		List<Endereco> enderecoImovel = enderecoRepository.findByImovel_ID(id);
		Optional<Pessoas> proprietario = pessoaRepository.findById(imovel.get().getProprietario().getID());
		return imovel.isPresent() ? ResponseEntity.ok(new DetalheImovelDTO(imovel,enderecoImovel,proprietario)): ResponseEntity.notFound().build();
		
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalheImovelDTO> atualizar( @Valid @RequestBody ImovelFormAtualizar imovelFormAtualizar, @PathVariable  Long id){
		
		Optional<Imoveis> buscaImovel = imovelRepository.findById(id);
		if(buscaImovel.isPresent()) {
			Imoveis imovel2 = imovelFormAtualizar.atualizar(id,imovelRepository);
			return ResponseEntity.ok(new DetalheImovelDTO(imovel2));
			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	

}
