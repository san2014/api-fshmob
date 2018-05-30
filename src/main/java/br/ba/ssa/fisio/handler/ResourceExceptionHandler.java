package br.ba.ssa.fisio.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.ba.ssa.fisio.model.DetalhesErro;
import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.service.exception.GenericException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ResponseApi<DetalhesErro>> handleGenericException
							(GenericException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.api.fisio.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.badRequest().body(new ResponseApi<>(erro));
		
	}	

}
