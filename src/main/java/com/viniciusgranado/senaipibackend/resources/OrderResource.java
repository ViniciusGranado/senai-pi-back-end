package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.*;
import com.viniciusgranado.senaipibackend.entities.dtos.OrderItemsInfo;
import com.viniciusgranado.senaipibackend.entities.dtos.ProductInfo;
import com.viniciusgranado.senaipibackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
  @Autowired
  OrderService orderService;

  @Autowired
  UserService userService;

  @Autowired
  OrderItemService orderItemService;

  @Autowired
  ProductService productService;

  @Autowired
  CartItemService cartItemService;

  @Autowired
  CartService cartService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable Long id) {
    Order obj = orderService.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Order> insert(@RequestBody OrderItemsInfo orderInfo) {
    // TODO return updated object
    User user = userService.findById(orderInfo.getClientId());
    Cart cart = cartService.findByClientId(orderInfo.getClientId());

    Order order = orderService.insert(new Order(null, user));

    List<OrderItem> obj = new ArrayList<>();

    Product product;
    for (ProductInfo item : orderInfo.getProducts()) {
      product = productService.findById(item.getProductId());

      obj.add(new OrderItem(order, product, item.getQuantity(), product.getPrice()));

      cartItemService.delete(new CartItem(cart, product));
    }

    orderItemService.insertAll(obj);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();

    return ResponseEntity.created(uri).body(order);
  }
}
