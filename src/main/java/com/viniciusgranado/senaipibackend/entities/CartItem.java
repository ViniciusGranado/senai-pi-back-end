package com.viniciusgranado.senaipibackend.entities;

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
  private Integer quatity;
  private Double price;

  public CartItem() {
  }

  public CartItem(Cart cart, Product product, Integer quatity, Double price) {
    id.setCart(cart);
    id.setProduct(product);
    this.quatity = quatity;
    this.price = price;
  }

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

  public Integer getQuatity() {
    return quatity;
  }

  public void setQuatity(Integer quatity) {
    this.quatity = quatity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getSubTotal() {
    return price * quatity;
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
