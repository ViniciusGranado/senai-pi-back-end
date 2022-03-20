package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.Order;
import com.viniciusgranado.senaipibackend.repositories.OrderRepository;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
  @Autowired
  OrderRepository repository;

  public Order findById(Long id) {
    Optional<Order> obj = repository.findById(id);

    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Order insert(Order obj) {
    return repository.save(obj);
  }
}
