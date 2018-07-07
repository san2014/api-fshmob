package br.ba.ssa.fisio.service.exception;

public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 698295177533613609L;

	public GenericException(String mensagem) {
		super(mensagem);
	}
	
	public GenericException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}	

}
