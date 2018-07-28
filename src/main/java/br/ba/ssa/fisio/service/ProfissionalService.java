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
	
	public Profissional obter(Long id) {
		
		try {
			return this.profissionalRepository.findById(id).get();
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
	
	public void excluir(Long id) {
		this.verificarExistencia(id);
		this.profissionalRepository.deleteById(id);
	}
	
	public List<Profissional> disponiveisEspecialidade(Long idEspecialidade, String cidade) {
		
		return this.profissionalRepository.disponiveisAtendimento(idEspecialidade, cidade);
		//return this.profissionalRepository.findAllByEspecialidadesIdAndUsuarioCidade(idEspecialidade, cidade);

	}

	private void verificarExistencia(Long id) {
		if (!this.profissionalRepository.existsById(id)) {
			throw new GenericException("Profissional inexistente!");
		}
	}

}
