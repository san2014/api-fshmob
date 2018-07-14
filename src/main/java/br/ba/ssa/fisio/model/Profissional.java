package br.ba.ssa.fisio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="pf_profissional")
public class Profissional{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prof_id")
	private Long id; 
	
	@ManyToOne
	@NotNull(message = "Um usuário existente deve ser informado")
	private Usuario usuario;

	@Column(name="prof_credenciamento")
	@NotNull(message = "O campo credenciamento não pode ser vazio")
    private String credenciamento;

	@Column(name="prof_conta")
	@NotNull(message = "Uma conta deve ser informada")
    private String conta;

	@Column(name="prof_agencia")
    @NotNull(message = "Uma agência deve ser informada")
    private String agencia;

	@Column(name="prof_banco")
	@NotNull(message = "Um banco deve ser informado")
    private String banco;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEspera;
    
    @OneToMany
    private List<Especialidade> especialidades;

    @Column(name="prof_disponivel")
    @NotNull
    private Boolean disponivel;
    
    @Column(name="prof_ativo")
    @NotNull
    private Boolean ativo;    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCredenciamento() {
		return credenciamento;
	}

	public void setCredenciamento(String credenciamento) {
		this.credenciamento = credenciamento;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Date getDataEspera() {
		return dataEspera;
	}
	
	public void setDataEspera(Date dataEspera) {
		this.dataEspera = dataEspera;
	}
	
	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
