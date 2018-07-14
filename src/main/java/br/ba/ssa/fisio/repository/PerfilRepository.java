package br.ba.ssa.fisio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ba.ssa.fisio.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	Perfil findByDescricao(String descricao);

}
