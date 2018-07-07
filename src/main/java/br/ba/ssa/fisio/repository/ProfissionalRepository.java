package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.model.Usuario;

public interface ProfissionalRepository extends MongoRepository<Profissional, String> {
	
	List<Profissional> findAllByUsuario(Usuario usuario);
	
}
