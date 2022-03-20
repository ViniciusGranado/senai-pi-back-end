package com.viniciusgranado.senaipibackend.entities.dtos;

import com.viniciusgranado.senaipibackend.entities.enums.Roles;

import java.io.Serializable;
import java.util.Objects;

public class UserInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Roles role;

  public UserInfo() {
  }

  public UserInfo(Long id, Roles role) {
    this.id = id;
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(id, userInfo.id) && role == userInfo.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, role);
  }
}
