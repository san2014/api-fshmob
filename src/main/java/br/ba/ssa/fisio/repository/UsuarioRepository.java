package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
    Usuario findByEmail(String email);
    
}
