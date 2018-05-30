package br.ba.ssa.fisio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.Profissional;

public interface ProfissionalRepository extends MongoRepository<Profissional, String> {

}
