package com.viniciusgranado.senaipibackend.resources.exceptions;

import com.viniciusgranado.senaipibackend.services.exceptions.InvalidPasswordException;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;

    StandardError err = new StandardError(
            Instant.now(),
            status.value(),
            error,
            e.getMessage(),
            request.getRequestURI()
    );

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(InvalidPasswordException.class)
  public ResponseEntity<StandardError> invalidPassword(InvalidPasswordException e, HttpServletRequest request) {
    String error = "Invalid Password";
    HttpStatus status = HttpStatus.UNAUTHORIZED;

    StandardError err = new StandardError(
            Instant.now(),
            status.value(),
            error,
            e.getMessage(),
            request.getRequestURI()
    );

    return ResponseEntity.status(status).body(err);
  }
}
