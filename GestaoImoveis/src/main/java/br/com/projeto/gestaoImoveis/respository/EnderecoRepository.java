package br.com.projeto.gestaoImoveis.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.gestaoImoveis.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	Optional<Endereco> findById(Long id);
	List<Endereco> findByPessoa_ID(Long Id);
	List<Endereco> findByPessoaID(Long Id);

}
