package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.dtos.NewCategoryDto;
import com.viniciusgranado.senaipibackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{reference}")
  public ResponseEntity<Category> findByReference(@PathVariable String reference) {
    Category obj = service.findByReference(reference);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Category> insert(@RequestBody NewCategoryDto category) {
    Category obj = service.insert(new Category(null, category.getName(), category.getReference()));

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }
}
