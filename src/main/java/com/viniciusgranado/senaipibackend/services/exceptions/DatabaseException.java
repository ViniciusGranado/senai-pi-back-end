package com.viniciusgranado.senaipibackend.services.exceptions;

public class DatabaseException extends RuntimeException {
  public DatabaseException(String message) {
    super(message);
  }
}
