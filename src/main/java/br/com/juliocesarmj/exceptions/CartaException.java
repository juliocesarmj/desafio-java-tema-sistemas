package br.com.juliocesarmj.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CartaException extends RuntimeException{
    private static final long serialVersionUID = 3292105740399761656L;

    private final HttpStatus httpStatus;

    public CartaException(final String mensagem, final HttpStatus httpStatus) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }
}
