package br.com.juliocesarmj.handler;

import br.com.juliocesarmj.exceptions.CartaException;
import br.com.juliocesarmj.model.ErrorMapResponse;
import br.com.juliocesarmj.model.ErrorMapResponse.ErrorMapResponseBuilder;
import br.com.juliocesarmj.model.ErrorResponse;
import br.com.juliocesarmj.model.ErrorResponse.ErrorResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(CartaException.class)
    public ResponseEntity<ErrorResponse> handlerCartaException(CartaException c) {
        ErrorResponseBuilder error = ErrorResponse.builder();
        error.mensagem(c.getMessage());
        error.httpStatus(c.getHttpStatus().value());
        error.timeStamp(System.currentTimeMillis());

        return ResponseEntity.status(c.getHttpStatus()).body(error.build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMapResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m) {
        Map<String, String> erros = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(erro-> {
            String campo = ((FieldError)erro).getField();
            String mensagem = erro.getDefaultMessage();
            erros.put(campo, mensagem);
        });
        ErrorMapResponseBuilder errorMap = ErrorMapResponse.builder();
        errorMap.erros(erros).httpStatus(HttpStatus.BAD_REQUEST.value()).timeStamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap.build());
    }
}
