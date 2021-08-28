package br.com.juliocesarmj.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {

    private int httpStatus;
    private String mensagem;
    private Long timeStamp;
}
