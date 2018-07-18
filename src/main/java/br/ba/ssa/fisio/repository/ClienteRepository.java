package br.ba.ssa.fisio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ba.ssa.fisio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
