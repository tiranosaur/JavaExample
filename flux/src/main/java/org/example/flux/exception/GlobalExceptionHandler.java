package org.example.flux.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler implements WebExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Mono<Void> handle(ServerWebExchange exchange, Exception ex) {
        if (ex instanceof ResponseStatusException) {
            log.error(
                    "GlobalExceptionHandler Exception status - [{}], message - [{}], reason - [{}]",
                    ((ResponseStatusException) ex).getStatusCode(), ex.getMessage(), ((ResponseStatusException) ex).getReason()
            );
            return Mono.error(ex);
        }
        log.error("GlobalExceptionHandler Exception message - [{}]", ex.getMessage());
        return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error("GlobalExceptionHandler Throwable message - [{}]", ex.getMessage());
        return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }
}