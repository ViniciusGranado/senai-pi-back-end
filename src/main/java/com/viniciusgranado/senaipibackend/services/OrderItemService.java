package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.OrderItem;
import com.viniciusgranado.senaipibackend.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
  @Autowired
  OrderItemRepository repository;

  public List<OrderItem> insertAll(List<OrderItem> items) {
    return repository.saveAll(items);
  }
}
