package br.ba.ssa.fisio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ba.ssa.fisio.model.TipoAtendimento;

public interface TipoAtendimentoRepository extends JpaRepository<TipoAtendimento, Long>{
	
}
