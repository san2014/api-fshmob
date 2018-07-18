package br.ba.ssa.fisio.service.exception;

public class ClienteInexistenteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7325823698620944847L;

	public ClienteInexistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteInexistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}		

}
