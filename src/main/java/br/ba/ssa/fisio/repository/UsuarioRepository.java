package br.ba.ssa.fisio.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.ba.ssa.fisio.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
    Usuario findByEmail(String email);
    
    GeoResults<Usuario> findByLocationNear(Point point, Distance distance);
    
}
