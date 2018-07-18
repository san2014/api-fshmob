package br.ba.ssa.fisio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="ap_usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4269693776050453451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usua_id")
	private Long id;
    
	@Column(name="usua_apelido")
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo APELIDO é de preechimento obrigatório.")
	private String apelido;

	@Column(name="usua_senha")
	@NotEmpty(message = "Campo SENHA é de preechimento obrigatório.")
	private String senha;

	@Column(name="usua_cpf")
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo CPF é de preechimento obrigatório.")
    private String cpf;

	@Column(name="usua_rg")
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo RG é de preechimento obrigatório.")
    private String rg;

	@Column(name="usua_nome")
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo NOME é de preechimento obrigatório.")
    private String nome;
    
	@Column(name="usua_dt_nasc")
	@NotNull(message = "Campo NASCIMENTO é de preechimento obrigatório.")
	@JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

	@Column(name="usua_cep")
	@NotNull(message = "Campo CEP é de preechimento obrigatório.")
    private Long cep;

	@Column(name="usua_logradouro")
	@JsonInclude(Include.NON_NULL)
    private String logradouro;

	@Column(name="usua_bairro")
	@JsonInclude(Include.NON_NULL)
    private String bairro;

	@Column(name="usua_cidade")
	@JsonInclude(Include.NON_NULL)
    private String cidade;
    
	@Column(name="usua_porta")
    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo PORTA é de preechimento obrigatório.")
    private String porta;

	@Column(name="usua_email")
    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo EMAIL é de preechimento obrigatório.")
    private String email;

	@Column(name="usua_imgurl")
    @JsonInclude(Include.NON_NULL)
    private String imgPerfil;

	@ManyToOne()
	@JoinColumn(name="usua_perf_id")
    @JsonInclude(Include.NON_NULL)
    private Perfil perfil;

	@Column(name="usua_sexo")
    @JsonInclude(Include.NON_NULL)
    @NotNull(message = "Campo SEXO é de preechimento obrigatório.")
    private Byte sexo;

	@Column(name="usua_facebook_id")
    @JsonInclude(Include.NON_NULL)
    private Long facebookId;

	@Column(name="usua_google_id")
    @JsonInclude(Include.NON_NULL)
    private Long googleId;

	@Column(name="usua_onesignal_id")
    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo ONESIGNALID é de preechimento obrigatório.")
    private String onesignalId;

	@Column(name="usua_ativo")
	private Boolean ativo = true;
    
    public Usuario() {}
    
	public Usuario(Long id) {
		super();
		this.id = id;
	}    
	
    public Usuario(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public Usuario(String nome, String email, String senha, Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgPerfil() {
		return imgPerfil;
	}

	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Byte getSexo() {
		return sexo;
	}

	public void setSexo(Byte sexo) {
		this.sexo = sexo;
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}

	public Long getGoogleId() {
		return googleId;
	}

	public void setGoogle_id(Long googleId) {
		this.googleId = googleId;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getOnesignalId() {
		return onesignalId;
	}

	public void setOnesignalId(String onesignalId) {
		this.onesignalId = onesignalId;
	}

	public void setGoogleId(Long googleId) {
		this.googleId = googleId;
	}


	
}
