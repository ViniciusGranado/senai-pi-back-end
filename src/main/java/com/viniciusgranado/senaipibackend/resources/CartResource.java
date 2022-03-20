package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Cart;
import com.viniciusgranado.senaipibackend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
public class CartResource {
  @Autowired
  private CartService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Cart> findByClientId(@PathVariable Long id) {
    Cart obj = service.findByClientId(id);

    return ResponseEntity.ok().body(obj);
  }
}
