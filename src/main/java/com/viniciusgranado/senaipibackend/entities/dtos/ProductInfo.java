package com.viniciusgranado.senaipibackend.entities.dtos;

import java.util.Objects;

public class ProductInfo {
  private Long productId;
  private Integer quantity;

  public ProductInfo() {
  }

  public ProductInfo(Long productId, Integer quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductInfo that = (ProductInfo) o;
    return Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, quantity);
  }
}
