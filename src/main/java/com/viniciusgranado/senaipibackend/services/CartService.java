package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.Cart;
import com.viniciusgranado.senaipibackend.repositories.CartRepository;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
  @Autowired
  CartRepository repository;

  public Cart findByClientId(Long id) {
    Optional<Cart> obj = repository.findByClientId(id);

    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Cart insert(Cart cart) {
    return repository.save(cart);
  }
}
