package br.ba.ssa.fisio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Profissional{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne
	@NotNull(message = "Um usuário existente deve ser informado")
	private Usuario usuario;

	@NotNull(message = "O campo credenciamento não pode ser vazio")
    private String credenciamento;

	@JsonFormat(pattern = "dd/MM/yyyy")
    private Date vencimento;

    @NotNull(message = "Uma conta deve ser informada")
    private String conta;

    @NotNull(message = "Uma agência deve ser informada")
    private String agencia;

    @NotNull(message = "Um banco deve ser informado")
    private String banco;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEspera;
    
    @OneToMany
    private List<TipoAtendimento> especialidades;

    @NotNull
    private Boolean disponivel;
    
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

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
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
	
	public List<TipoAtendimento> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<TipoAtendimento> especialidades) {
		this.especialidades = especialidades;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Date getDataEspera() {
		return dataEspera;
	}

	public void setDataEspera(Date dataEspera) {
		this.dataEspera = dataEspera;
	}

}
