package br.ba.ssa.fisio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Cliente;
import br.ba.ssa.fisio.repository.ClienteRepository;
import br.ba.ssa.fisio.service.exception.ClienteInexistenteException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listar(){
		return this.clienteRepository.findAll();
	}
	
	public Cliente obter(Long id) {
		
		this.verificarExistencia(id);
		
		return this.clienteRepository.findById(id).get();
		
	}
	
	public Cliente inserir(Cliente cliente) {
		
		return this.clienteRepository.save(cliente);
		
	}
	
	public void atualizar(Cliente cliente) {
		
		this.verificarExistencia(cliente.getId());
		
		this.clienteRepository.save(cliente);
		
	}
	
	public void deletar(Long id) {
		
		this.verificarExistencia(id);
		
		this.clienteRepository.deleteById(id);
		
	}	
	
	private void verificarExistencia(Long id) {
		
		if (!clienteRepository.existsById(id)) {
			throw new ClienteInexistenteException("Cliente: Id inexistente");
		}
		
	}

}
