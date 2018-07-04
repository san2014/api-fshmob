package br.ba.ssa.fisio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.repository.UsuarioRepository;
import br.ba.ssa.fisio.service.exception.GenericException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	public List<Usuario> listar(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario obter(String id) {
		try {
			return this.usuarioRepository.findOne(id);
		} catch (NoSuchElementException e) {
			throw new GenericException("Usuário Inexisente");
		}
	}
	
	public Usuario incluir(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public void atualizar(Usuario usuario) {
		this.verificarExistencia(usuario.getId());
		this.usuarioRepository.save(usuario);
	}
	
	public void excluir(String id) {
		this.verificarExistencia(id);
		this.usuarioRepository.delete(id);
	}
	
	public Optional<Usuario> buscaPorEmail(String email){
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}

	public List<Usuario> getByCoordenadas(Point coordenadas, String perfil) {
		
		NearQuery nearQuery = NearQuery.near(new Point(coordenadas))
				.minDistance(0.00)
				.maxDistance(new Distance(200, Metrics.KILOMETERS))
				.skip(1);
		
		GeoResults<Usuario> data = this.mongoTemplate.geoNear(nearQuery, Usuario.class);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		for (GeoResult<?> geoResult : data.getContent()) {
			Usuario usuario  = (Usuario) geoResult.getContent();
			usuarios.add(usuario);
		}
		
		return usuarios;

	}	
	
	private void verificarExistencia(String id) {
		if (!this.usuarioRepository.exists(id)) {
			throw new GenericException("Usuário inexistente!");
		}
	}
	
}
