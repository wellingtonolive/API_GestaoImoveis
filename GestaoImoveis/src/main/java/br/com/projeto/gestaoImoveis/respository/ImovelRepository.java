package br.com.projeto.gestaoImoveis.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.gestaoImoveis.models.Imoveis;

public interface ImovelRepository extends JpaRepository<Imoveis, Long>{
	
	Optional<Imoveis> findById(Long ID);
	
	
	

}
