package br.ba.ssa.fisio.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
    
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo APELIDO é de preechimento obrigatório.")
	private String apelido;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo SENHA é de preechimento obrigatório.")
	private String senha;

	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo CPF é de preechimento obrigatório.")
    private Long cpf;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo RG é de preechimento obrigatório.")
    private String rg;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo NOME é de preechimento obrigatório.")
    private String nome;
    
	@NotNull(message = "Campo NASCIMENTO é de preechimento obrigatório.")
	@JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

	@NotNull(message = "Campo CEP é de preechimento obrigatório.")
    private Long cep;

	@JsonInclude(Include.NON_NULL)
    private String logradouro;

	@JsonInclude(Include.NON_NULL)
    private String bairro;

	@JsonInclude(Include.NON_NULL)
    private String cidade;
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonInclude(Include.NON_NULL)
    private Point location;
    
    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo PORTA é de preechimento obrigatório.")
    private String porta;

    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo EMAIL é de preechimento obrigatório.")
    private String email;

    @JsonInclude(Include.NON_NULL)
    private String imgperfil;

    @JsonInclude(Include.NON_NULL)
    private PerfilEnum perfil;

    @JsonInclude(Include.NON_NULL)
    @NotNull(message = "Campo SEXO é de preechimento obrigatório.")
    private Byte sexo;

    @JsonInclude(Include.NON_NULL)
    private Long facebookId;

    @JsonInclude(Include.NON_NULL)
    private Long googleId;

    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo ONESIGNALID é de preechimento obrigatório.")
    private String onesignalId;

    private Boolean ativo;
    
    public Usuario() {}
    
	public Usuario(String id) {
		super();
		this.id = id;
	}    
	
    public Usuario(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public Usuario(String nome, String email, String senha, PerfilEnum perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
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
	

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
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

	public String getImgperfil() {
		return imgperfil;
	}

	public void setImgperfil(String imgperfil) {
		this.imgperfil = imgperfil;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
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
