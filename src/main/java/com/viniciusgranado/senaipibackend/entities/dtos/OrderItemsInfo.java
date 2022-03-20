package com.viniciusgranado.senaipibackend.entities.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderItemsInfo {
  private Long clientId;
  private List<ProductInfo> products = new ArrayList<>();

  public OrderItemsInfo() {
  }

  public OrderItemsInfo(Long orderId, List<ProductInfo> products) {
    this.clientId = orderId;
    this.products = products;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public List<ProductInfo> getProducts() {
    return products;
  }

  public void setProducts(List<ProductInfo> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderItemsInfo that = (OrderItemsInfo) o;
    return Objects.equals(clientId, that.clientId) && Objects.equals(products, that.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, products);
  }
}
