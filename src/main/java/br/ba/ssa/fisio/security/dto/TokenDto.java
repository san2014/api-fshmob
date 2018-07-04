package br.ba.ssa.fisio.security.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TokenDto {
	
	private String token;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Date dataExpiracao;
	
	public TokenDto() {
	}

	public TokenDto(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
}
