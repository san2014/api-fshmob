package br.ba.ssa.fisio.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.repository.ProfissionalRepository;
import br.ba.ssa.fisio.service.exception.GenericException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public List<Profissional> listar(){
		return this.profissionalRepository.findAll();
	}
	
	public Profissional obter(String id) {
		
		try {
			return this.profissionalRepository.findOne(id);
		} catch (NoSuchElementException e) {
			throw new GenericException("Profissional Inexisente");
		}

	}
	
	public Profissional incluir(Profissional profissional) {
		return this.profissionalRepository.save(profissional);
	}
	
	public Profissional atualizar(Profissional profissional) {
		this.verificarExistencia(profissional.getId());
		return this.profissionalRepository.save(profissional);
	}
	
	public void excluir(String id) {
		this.verificarExistencia(id);
		this.profissionalRepository.delete(id);
	}
	
	private void verificarExistencia(String id) {
		if (!this.profissionalRepository.exists(id)) {
			throw new GenericException("Profissional inexistente!");
		}
	}

}
