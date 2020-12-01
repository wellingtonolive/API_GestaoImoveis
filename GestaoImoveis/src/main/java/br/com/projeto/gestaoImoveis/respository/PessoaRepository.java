package br.com.projeto.gestaoImoveis.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.gestaoImoveis.models.Pessoas;

public interface PessoaRepository extends JpaRepository<Pessoas, Long>{
	
	Optional<Pessoas> findById(Long Id);
	Optional<Pessoas> findByNome(String nome);
	Optional<Pessoas> findByCpf(String cpf);

}
