package br.ba.ssa.fisio.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.TipoAtendimento;
import br.ba.ssa.fisio.repository.TipoAtendimentoRepository;
import br.ba.ssa.fisio.service.exception.GenericException;

@Service
public class TipoAtendimentoService {

	@Autowired
	private TipoAtendimentoRepository tipoAtendimentoRepository;
	
	public List<TipoAtendimento> listar(){
		return this.tipoAtendimentoRepository.findAll();
	}
	
	public TipoAtendimento obter(Long id) {
		
		try {
			return this.tipoAtendimentoRepository.findOne(id);
		} catch (NoSuchElementException e) {
			throw new GenericException("Profissional Inexisente");
		}

	}
	
	public TipoAtendimento incluir(TipoAtendimento tipoAtendimento) {
		return this.tipoAtendimentoRepository.save(tipoAtendimento);
	}
	
	public void atualizar(TipoAtendimento tipoAtendimento) {
		this.verificarExistencia(tipoAtendimento.getId());
		this.tipoAtendimentoRepository.save(tipoAtendimento);
	}
	
	public void excluir(Long id) {
		this.verificarExistencia(id);
		this.tipoAtendimentoRepository.delete(id);
	}
	
	private void verificarExistencia(Long id) {
		if (!this.tipoAtendimentoRepository.exists(id)) {
			throw new GenericException("Tipo Atendimento inexistente!");
		}
	}	
}
