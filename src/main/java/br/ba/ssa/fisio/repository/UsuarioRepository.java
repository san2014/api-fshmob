package br.ba.ssa.fisio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
}
