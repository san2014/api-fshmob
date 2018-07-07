package br.ba.ssa.fisio.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.repository.ProfissionalRepository;
import br.ba.ssa.fisio.service.exception.GenericException;
import br.ba.ssa.fisio.service.exception.ProfissionaisIndisPoniveisException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
    MongoTemplate mongoTemplate;	
	
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
	
	public List<Profissional> disponiveisCidade(String cidade){
		
		Usuario userSearch = new Usuario();
		
		userSearch.setCidade(cidade);
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("usuario.cidade").is(cidade)
				.and("disponivel").is(true));
		
		query.with(new Sort(Sort.Direction.ASC, "dataEspera"));
		
		List<Profissional> profissionais = mongoTemplate.find(query, Profissional.class);
		
		return profissionais;
		
	}
	
	private void verificarExistencia(String id) {
		if (!this.profissionalRepository.exists(id)) {
			throw new GenericException("Profissional inexistente!");
		}
	}

}
