package br.ba.ssa.fisio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Perfil;
import br.ba.ssa.fisio.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> listar(){
		return this.perfilRepository.findAll();
	}
	
	public Perfil inserir(Perfil perfil) {
		return this.perfilRepository.save(perfil);
	}

}
