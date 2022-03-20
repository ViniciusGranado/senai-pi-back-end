package com.viniciusgranado.senaipibackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciusgranado.senaipibackend.entities.pk.CartItemPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cart_item")
public class CartItem implements Serializable {
  @EmbeddedId
  private CartItemPk id = new CartItemPk();
  private Double price;

  public CartItem() {
  }

  public CartItem(Cart cart, Product product, Double price) {
    id.setCart(cart);
    id.setProduct(product);
    this.price = price;
  }

  @JsonIgnore
  public Cart getCart() {
    return id.getCart();
  }

  public void setCart(Cart cart) {
    id.setCart(cart);
  }

  public Product getProduct() {
    return id.getProduct();
  }

  public void setProduct(Product product) {
    id.setProduct(product);
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CartItem cartItem = (CartItem) o;
    return Objects.equals(id, cartItem.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
