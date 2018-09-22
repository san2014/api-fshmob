package br.ba.ssa.fisio.service;

import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Proposta;
import br.ba.ssa.fisio.repository.PropostaRepository;
import br.ba.ssa.fisio.service.exception.GenericException;

@Service
public class PropostaService {
	
	private PropostaRepository propostaRepository;
	
	public Proposta obter(Long id) {
		
		return this.propostaRepository.getOne(id);
		
	}
	
	public Proposta inserir(Proposta proposta) {
		
		return this.propostaRepository.save(proposta);
		
	}
	
	public void atualizar(Proposta proposta) {
		
		this.verificarExistencia(proposta.getId());
		
		this.propostaRepository.save(proposta);
		
	}
	
	public void deletar(Long id) {
		
		this.verificarExistencia(id);
		
		this.propostaRepository.deleteById(id);
		
	}
	
	private void verificarExistencia(Long id) {
		
		if (!this.propostaRepository.existsById(id)) {
			throw new GenericException("Proposta: Id inexistente");
		}
		
	}	

}
