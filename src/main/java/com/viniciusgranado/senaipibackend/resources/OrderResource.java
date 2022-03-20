package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Order;
import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.services.OrderService;
import com.viniciusgranado.senaipibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
  @Autowired
  OrderService orderService;

  @Autowired
  UserService userService;

  @PostMapping(value = "/{clientId}")
  public ResponseEntity<Order> insert(@PathVariable Long clientId) {
    User user = userService.findById(clientId);

    Order obj = orderService.insert(new Order(null, user));

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }
}
