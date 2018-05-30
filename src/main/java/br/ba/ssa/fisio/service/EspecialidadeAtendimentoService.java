package br.ba.ssa.fisio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.EspecialidadeAtendimento;
import br.ba.ssa.fisio.repository.EspecialidadeAtendimentoRepository;

@Service
public class EspecialidadeAtendimentoService {
	
	@Autowired
	private EspecialidadeAtendimentoRepository especialidadeAtendimentoRepository;
	
	public List<EspecialidadeAtendimento> listar(){
		return this.especialidadeAtendimentoRepository.findAll();
	}
	
	public EspecialidadeAtendimento incluir(EspecialidadeAtendimento especialidadeAtendimento) {
		return this.especialidadeAtendimentoRepository.save(especialidadeAtendimento);
	}

}
