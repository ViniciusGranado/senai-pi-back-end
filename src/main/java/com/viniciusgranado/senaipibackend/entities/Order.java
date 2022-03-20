package com.viniciusgranado.senaipibackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JsonIgnore
  @JoinColumn(name = "client_id")
  private User client;

  @OneToMany(mappedBy = "id.order")
  private Set<OrderItem> items = new HashSet<>();

  public Order() {
  }

  public Order(Long id, User client) {
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

  public Set<OrderItem> getItems() {
    return items;
  }

  public Double getTotal() {
    double total = 0d;

    for(OrderItem item : items) {
      total += item.getSubTotal();
    }

    return total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
