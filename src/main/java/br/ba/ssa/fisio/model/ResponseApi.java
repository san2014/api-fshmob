package br.ba.ssa.fisio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResponseApi<T> {
	
	@JsonInclude(Include.NON_NULL)
	private T data;
	
	@JsonInclude(Include.NON_NULL)
	private List<String> erros;
	
	public ResponseApi(T data) {
		this.data = data;
	}
	
	public ResponseApi(List<String> erros) {
		this.erros = erros;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<String> getErros() {
		return erros;
	}
	
	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
}
