package com.viniciusgranado.senaipibackend.entities.dtos;

import java.io.Serializable;
import java.util.Objects;

public class CartItemData implements Serializable {
  private Long productId;
  private Long cartId;

  public CartItemData() {
  }

  public CartItemData(Long clientId, Long cartId) {
    this.productId = clientId;
    this.cartId = cartId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getCartId() {
    return cartId;
  }

  public void setCartId(Long cartId) {
    this.cartId = cartId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CartItemData that = (CartItemData) o;
    return Objects.equals(productId, that.productId) && Objects.equals(cartId, that.cartId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, cartId);
  }
}
