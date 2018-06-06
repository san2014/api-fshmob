package br.ba.ssa.fisio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

	Perfil findByNome(String nome);

}
