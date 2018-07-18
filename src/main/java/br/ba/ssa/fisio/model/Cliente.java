package br.ba.ssa.fisio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cl_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clte_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="clte_usua_id")
	private Usuario usuario;
	
	@Column(name="clte_ativo")
	private Boolean ativo;
	
	public Cliente() {
	}
	
	public Cliente(Long id) {
		super();
		this.id = id;
	}



	public Cliente(Long id, Usuario usuario, Boolean ativo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
