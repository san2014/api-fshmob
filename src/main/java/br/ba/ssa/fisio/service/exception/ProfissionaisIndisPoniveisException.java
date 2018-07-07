package br.ba.ssa.fisio.service.exception;

public class ProfissionaisIndisPoniveisException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4963734656635500902L;

	public ProfissionaisIndisPoniveisException() {
		super("Não encontramos profisisonais para sua busca, por favor tente mais tarde...");
	}
	
	public ProfissionaisIndisPoniveisException(String mensagem) {
		super(mensagem);
	}
	
	public ProfissionaisIndisPoniveisException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}		

}
