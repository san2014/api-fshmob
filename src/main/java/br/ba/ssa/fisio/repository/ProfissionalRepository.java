package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.model.Usuario;

public interface ProfissionalRepository extends MongoRepository<Profissional, String> {
	
	List<Profissional> findAllByEspecialidadesAndUsuario(String idEspecilidade, Usuario usuario);
	
}
