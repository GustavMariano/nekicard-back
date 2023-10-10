package br.com.neki.nekicard.infra.exception;

public class ValidacaoException extends RuntimeException {
    
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
