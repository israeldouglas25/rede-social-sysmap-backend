package br.com.sysmap.redesocial.api.exceptionhandler;

import br.com.sysmap.redesocial.exception.DomainException;
import br.com.sysmap.redesocial.exception.EntitieNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Properties> properties = new ArrayList<>();

        for(ObjectError error: ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();

            properties.add(new Properties(nome, mensagem));
        }

        Problem problema = new Problem();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo("Um ou mais campos inválidos. Tente novamente!");
        problema.setProperties(properties);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomain(DomainException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problem problema = new Problem();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(EntitieNotFoundException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntitieNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problem problema = new Problem();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }
}
