package com.viniciusgranado.senaipibackend.entities;

import java.io.Serializable;
import java.util.Objects;

public class LoginForm implements Serializable {
  private String username;
  private String password;

  public LoginForm() {
  }

  public LoginForm(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LoginForm loginForm = (LoginForm) o;
    return Objects.equals(username, loginForm.username) && Objects.equals(password, loginForm.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }
}
