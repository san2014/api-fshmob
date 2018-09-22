package br.ba.ssa.fisio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="proposta")
public class Proposta {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="prop_tpat_id")
	private TipoAtendimento tipoAtendimento;
	
	@ManyToOne
	@JoinColumn(name="prop_clie_id")
	private Cliente cliente;
	
	@Column(name="prop_qtd")
	private Integer qtd;
	
	@Column(name="prop_avaliacao_clie")
	private String avaliacaoCliente;
	
	@Column(name="prop_avaliacao_prof")
	private String avaliacaoProfissional;
	
	@ManyToOne
	@JoinColumn(name="prop_ntvc_id")
	private Integer notaCliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getAvaliacaoCliente() {
		return avaliacaoCliente;
	}

	public void setAvaliacaoCliente(String avaliacaoCliente) {
		this.avaliacaoCliente = avaliacaoCliente;
	}

	public String getAvaliacaoProfissional() {
		return avaliacaoProfissional;
	}

	public void setAvaliacaoProfissional(String avaliacaoProfissional) {
		this.avaliacaoProfissional = avaliacaoProfissional;
	}

	public Integer getNotaCliente() {
		return notaCliente;
	}

	public void setNotaCliente(Integer notaCliente) {
		this.notaCliente = notaCliente;
	}
	
}
