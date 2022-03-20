package com.viniciusgranado.senaipibackend.entities.pk;

import com.viniciusgranado.senaipibackend.entities.Cart;
import com.viniciusgranado.senaipibackend.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemPk implements Serializable {
  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CartItemPk that = (CartItemPk) o;
    return Objects.equals(cart, that.cart) && Objects.equals(product, that.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cart, product);
  }
}
