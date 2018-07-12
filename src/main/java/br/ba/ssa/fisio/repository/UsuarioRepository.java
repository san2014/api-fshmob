package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ba.ssa.fisio.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
    Usuario findByEmail(String email);
    
}
