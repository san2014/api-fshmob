package br.ba.ssa.fisio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1081065664774834904L;

	@Id
	private String id;
	
	private String nome;
	
	public Perfil() {
		
	}
	
	public Perfil(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return nome;
	}
	
}
