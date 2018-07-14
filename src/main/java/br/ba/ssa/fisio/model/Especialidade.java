package br.ba.ssa.fisio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="at_especialidade")
public class Especialidade {

	@Id
	@Column(name="espc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="espc_descricao")
	@NotNull(message="Campo descricao é obrigatório")
	private String descricao;
	
	@Column(name="espc_ativo")
	private Boolean ativo;
	
	public Especialidade() {}

	public Especialidade(Long id) {
		super();
		this.id = id;
	}
	
	public Especialidade(Long id, String descricao, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
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
	
	
	
}
