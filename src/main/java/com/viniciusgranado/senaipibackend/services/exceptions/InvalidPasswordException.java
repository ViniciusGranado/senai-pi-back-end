package com.viniciusgranado.senaipibackend.services.exceptions;

public class InvalidPasswordException extends RuntimeException {
  public InvalidPasswordException() {
    super("Invalid Password");
  }
}
