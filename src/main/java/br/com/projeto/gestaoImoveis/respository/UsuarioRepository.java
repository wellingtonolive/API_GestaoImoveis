package br.com.projeto.gestaoImoveis.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.gestaoImoveis.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
