package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.CartItem;
import com.viniciusgranado.senaipibackend.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
  @Autowired
  CartItemRepository repository;

  public CartItem insert(CartItem obj) {
    return repository.save(obj);
  }
}
