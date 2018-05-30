package br.ba.ssa.fisio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.EspecialidadeAtendimento;

public interface EspecialidadeAtendimentoRepository extends MongoRepository<EspecialidadeAtendimento, String> {

}
