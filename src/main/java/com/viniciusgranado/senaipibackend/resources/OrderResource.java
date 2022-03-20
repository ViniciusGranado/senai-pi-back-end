package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Order;
import com.viniciusgranado.senaipibackend.entities.OrderItem;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.entities.dtos.OrderItemsInfo;
import com.viniciusgranado.senaipibackend.entities.dtos.ProductInfo;
import com.viniciusgranado.senaipibackend.services.OrderItemService;
import com.viniciusgranado.senaipibackend.services.OrderService;
import com.viniciusgranado.senaipibackend.services.ProductService;
import com.viniciusgranado.senaipibackend.services.UserService;
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

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable Long id) {
    Order obj = orderService.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Order> insert(@RequestBody OrderItemsInfo orderInfo) {
    // TODO return updated object
    User user = userService.findById(orderInfo.getClientId());

    Order order = orderService.insert(new Order(null, user));

    List<OrderItem> obj = new ArrayList<>();

    Product product;
    for (ProductInfo item : orderInfo.getProducts()) {
      product = productService.findById(item.getProductId());

      obj.add(new OrderItem(order, product, item.getQuantity(), product.getPrice()));
    }

    orderItemService.insertAll(obj);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();

    return ResponseEntity.created(uri).body(order);
  }
}
