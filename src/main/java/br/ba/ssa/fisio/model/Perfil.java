package br.ba.ssa.fisio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ap_perfil")
public class Perfil implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1081065664774834904L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="perf_id")	
	private Long id;
	
	@Column(name="perf_descricao")
	private String descricao;
	
	@Column(name="perf_ativo")
	private Boolean ativo;
	
	public Perfil() {
		
	}
	
	public Perfil(Long id, String descricao, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
	}



	public Perfil(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String getAuthority() {
		return descricao;
	}
	
}
