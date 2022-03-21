package com.viniciusgranado.senaipibackend.entities.dtos;

import java.io.Serializable;
import java.util.Objects;

public class NewCategoryDto implements Serializable {
  private String name;
  private String reference;

  public NewCategoryDto() {
  }

  public NewCategoryDto(String name, String reference) {
    this.name = name;
    this.reference = reference;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewCategoryDto that = (NewCategoryDto) o;
    return Objects.equals(name, that.name) && Objects.equals(reference, that.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, reference);
  }
}
