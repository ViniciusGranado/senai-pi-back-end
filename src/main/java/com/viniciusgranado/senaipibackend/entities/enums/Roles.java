package com.viniciusgranado.senaipibackend.entities.enums;

public enum Roles {
  COMMON(1),
  ADMIN(2);

  private int code;

  private Roles(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static Roles valueOf(int code) {
    for (Roles value : Roles.values()) {
      if (value.getCode() == code) {
        return value;
      }
    }

    throw new IllegalArgumentException("Invalid Roles code");
  }
}
