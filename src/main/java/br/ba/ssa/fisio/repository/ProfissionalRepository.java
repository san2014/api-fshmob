package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.model.Usuario;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	
	List<Profissional> findAllByEspecialidadesAndUsuario(String idEspecilidade, Usuario usuario);
	
}
