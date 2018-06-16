package br.ba.ssa.fisio.security.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class JwtAuthenticationDto {

	private String email;

	private String senha;
	
	public JwtAuthenticationDto() {
	}

	@NotEmpty(message = "E-mail não pode ser vazio")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "Senha não pode ser vazia")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "JwtAuthenticationRequestDto [email=" + this.email + ", senha=" + this.senha + "]";
	}

}
