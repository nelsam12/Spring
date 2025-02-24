package sn.ism.auchan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
@ControllerAdvice
public class InterceptorExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundHandler(EntityNotFoundException exception) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
