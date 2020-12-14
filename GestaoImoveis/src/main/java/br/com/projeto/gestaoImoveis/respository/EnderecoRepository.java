package br.com.projeto.gestaoImoveis.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Pessoas;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	Optional<Endereco> findById(Long id);
	List<Endereco> findByID(Long id);
	Optional<Endereco> findByCep(String cep);
	Optional<Endereco> findByIDAndCep(Long id, String cep);
	Optional<Endereco> findByIDAndCepAndPessoa(Long id, String Cep, Pessoas idPessoa);
	List<Endereco> findByPessoa_ID(Long Id);
	List<Endereco> findByPessoaID(Long Id);
	List<Endereco> findByImovel_ID(Long ID);
}
