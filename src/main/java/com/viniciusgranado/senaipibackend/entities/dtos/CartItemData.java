package com.viniciusgranado.senaipibackend.entities.dtos;

import java.io.Serializable;
import java.util.Objects;

public class CartItemData implements Serializable {
  private Long productId;
  private Long clientId;

  public CartItemData() {
  }

  public CartItemData(Long clientId, Long cartId) {
    this.productId = clientId;
    this.clientId = cartId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CartItemData that = (CartItemData) o;
    return Objects.equals(productId, that.productId) && Objects.equals(clientId, that.clientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, clientId);
  }
}
