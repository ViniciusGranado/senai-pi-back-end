package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.Order;
import com.viniciusgranado.senaipibackend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  @Autowired
  OrderRepository repository;

  public Order insert(Order obj) {
    return repository.save(obj);
  }
}
