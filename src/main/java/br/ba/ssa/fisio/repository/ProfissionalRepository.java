package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ba.ssa.fisio.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	
	@Query("select p from Profissional p inner join p.usuario u inner join p.especialidades e "
			+ "where u.cidade = :cidade and e.id = :idEspecialidade and u.onesignalId is not null "
			+ "and p.ativo = 1")
	List<Profissional> disponiveisAtendimento(@Param("idEspecialidade") Long idEspecialidade, 
											  @Param("cidade") String cidade);
	
}
