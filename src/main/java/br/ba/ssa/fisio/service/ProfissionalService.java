package br.ba.ssa.fisio.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.repository.ProfissionalRepository;
import br.ba.ssa.fisio.service.exception.GenericException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	@Autowired
	MongoOperations mongoOperations;	
	
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
	
/*	public List<Profissional> disponiveisEspecialidade(String cidade, String idEspecialidade){
		
		Usuario userSearch = new Usuario();
		
		userSearch.setCidade(cidade);
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("usuario.cidade").is(cidade)
				.and("especialidades.id").is(idEspecialidade)
				.and("disponivel").is(true))
				.limit(10);
		
		query.with(new Sort(Sort.Direction.ASC, "dataEspera"));
		
		List<Profissional> profissionais = mongoTemplate.find(query, Profissional.class);
		
		return profissionais;
		
	}
	*/
	
	public List<Profissional> disponiveisEspecialidade(String cidade, String idEspecialidade) {

		MatchOperation match = Aggregation.match(Criteria.where("cidade").is(cidade));
		
		LookupOperation lookupOperation = 
				LookupOperation.newLookup()
				.from("usuario")
				.localField("usuario.id")
				.foreignField("id")
				.as("usuario_prof");
		
		Aggregation aggregation = Aggregation.newAggregation(lookupOperation, match,
				Aggregation.group("id"));
		
		AggregationResults<Profissional> results = mongoOperations.aggregate(aggregation, Usuario.class, Profissional.class);

		List<Profissional> lista = results.getMappedResults();
		
		return lista;

	}

	private void verificarExistencia(String id) {
		if (!this.profissionalRepository.exists(id)) {
			throw new GenericException("Profissional inexistente!");
		}
	}

}
