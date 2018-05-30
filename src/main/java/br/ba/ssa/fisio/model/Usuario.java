package br.ba.ssa.fisio.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Usuario {
	
	@Id
	private String id;
    
	@NotEmpty(message = "Campo APELIDO é de preechimento obrigatório.")
	private String apelido;

	@NotEmpty(message = "Campo SENHA é de preechimento obrigatório.")
	private String senha;

	@NotNull(message = "Campo CPF é de preechimento obrigatório.")
    private Long cpf;

	@NotEmpty(message = "Campo RG é de preechimento obrigatório.")
    private String rg;

	@NotEmpty(message = "Campo NOME é de preechimento obrigatório.")
    private String nome;
    
	@NotNull(message = "Campo NASCIMENTO é de preechimento obrigatório.")
	@JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

	@NotNull(message = "Campo CEP é de preechimento obrigatório.")
    private Long cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    @NotEmpty(message = "Campo PORTA é de preechimento obrigatório.")
    private String porta;

    @NotEmpty(message = "Campo EMAIL é de preechimento obrigatório.")
    private String email;

    private String imgperfil;

    private Integer tipo;

    @NotNull(message = "Campo SEXO é de preechimento obrigatório.")
    private Integer sexo;

    private Long facebookId;

    private Long googleId;

    @NotEmpty(message = "Campo ONESIGNALID é de preechimento obrigatório.")
    private String onesignalId;

    private Byte flag_ativo;
    
    @DBRef
    private List<Perfil> perfis;
    
    public Usuario() {}
    
	public Usuario(String id) {
		super();
		this.id = id;
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
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

	public String getOnesignaId() {
		return onesignalId;
	}

	public void setOnesignal_id(String onesignalId) {
		this.onesignalId = onesignalId;
	}

	public byte getFlag_ativo() {
		return flag_ativo;
	}

	public void setFlag_ativo(byte flag_ativo) {
		this.flag_ativo = flag_ativo;
	}

	public String getOnesignalId() {
		return onesignalId;
	}

	public void setOnesignalId(String onesignalId) {
		this.onesignalId = onesignalId;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public void setGoogleId(Long googleId) {
		this.googleId = googleId;
	}

}
