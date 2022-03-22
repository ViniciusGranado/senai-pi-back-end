package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Cart;
import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.entities.dtos.LoginForm;
import com.viniciusgranado.senaipibackend.entities.dtos.UserInfo;
import com.viniciusgranado.senaipibackend.services.CartService;
import com.viniciusgranado.senaipibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  private UserService userService;

  @Autowired
  private CartService cartService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = userService.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User obj = userService.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User newUser) {
    User obj = userService.insert(newUser);

    cartService.insert(new Cart(null, obj));

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }

  @GetMapping(value = "/username/{username}")
  public ResponseEntity<User> findByUsername(@PathVariable String username) {
    User obj = userService.findByUsername(username);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping(value = "/login")
  public ResponseEntity<UserInfo> findIfUserPasswordIsCorrect(@RequestBody LoginForm loginForm) {
    UserInfo obj = userService.findIfUserPasswordIsCorrect(loginForm.getUsername(), loginForm.getPassword());

    return ResponseEntity.ok().body(obj);
  }
}
