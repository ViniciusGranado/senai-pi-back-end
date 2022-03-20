package com.viniciusgranado.senaipibackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_cart")
public class Cart implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JsonIgnore
  @JoinColumn(name = "client_id")
  private User client;

  @OneToMany(mappedBy = "id.cart")
  private Set<CartItem> items = new HashSet<>();

  public Cart() {
  }

  public Cart(Long id, User client) {
    this.id = id;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public Set<CartItem> getItems() {
    return items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cart cart = (Cart) o;
    return Objects.equals(id, cart.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
