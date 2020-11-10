package br.com.projeto.gestaoImoveis.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.gestaoImoveis.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	Optional<Usuario> findById(Long Id);
	Optional<Usuario> findByNmUsuario(String nmUsuario);
	Optional<Usuario> findByEmail(String email);

}
