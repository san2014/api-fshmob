package br.ba.ssa.fisio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.TipoAtendimento;

public interface TipoAtendimentoRepository extends MongoRepository<TipoAtendimento, String>{
	
}
