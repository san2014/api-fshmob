package br.ba.ssa.fisio.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.repository.UsuarioRepository;
import br.ba.ssa.fisio.service.exception.GenericException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario obter(String id) {
		try {
			return this.usuarioRepository.findById(id).get();
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
		this.usuarioRepository.deleteById(id);
	}
	
	private void verificarExistencia(String id) {
		if (!this.usuarioRepository.existsById(id)) {
			throw new GenericException("Usuário inexistente!");
		}
	}	

}
