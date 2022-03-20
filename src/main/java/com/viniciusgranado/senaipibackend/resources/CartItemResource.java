package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Cart;
import com.viniciusgranado.senaipibackend.entities.CartItem;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.entities.dtos.CartItemData;
import com.viniciusgranado.senaipibackend.services.CartItemService;
import com.viniciusgranado.senaipibackend.services.CartService;
import com.viniciusgranado.senaipibackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cart-item")
public class CartItemResource {
  @Autowired
  CartItemService cartItemService;

  @Autowired
  ProductService productService;

  @Autowired
  CartService cartService;

  @PostMapping
  public ResponseEntity<CartItem> insert(@RequestBody CartItemData newCartItem) {
    Cart cart = cartService.findByClientId(newCartItem.getCartId());
    Product product = productService.findById(newCartItem.getProductId());

    CartItem obj = new CartItem(cart, product);

    cartItemService.insert(obj);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCart().getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }
}
