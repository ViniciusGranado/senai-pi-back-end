package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.LoginForm;
import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.entities.enums.Roles;
import com.viniciusgranado.senaipibackend.services.CategoryService;
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
  private UserService service;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User obj = service.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User newUser) {
    User obj = service.insert(newUser);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }

  @GetMapping(value = "/username/{username}")
  public ResponseEntity<User> findByUsername(@PathVariable String username) {
    User obj = service.findByUsername(username);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping(value = "/login")
  public ResponseEntity<Roles> findIfUserPasswordIsCorrect(@RequestBody LoginForm loginForm) {
    Roles obj = service.findIfUserPasswordIsCorrect(loginForm.getUsername(), loginForm.getPassword());

    return ResponseEntity.ok().body(obj);
  }
}
