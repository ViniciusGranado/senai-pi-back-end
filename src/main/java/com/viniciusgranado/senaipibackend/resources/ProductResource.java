package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product obj = service.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @GetMapping(value = "/categories")
  public ResponseEntity<List<Product>> findAllByCategoriesIn(@RequestBody Set<Category> categories) {
    List<Product> list = service.findAllByCategoriesIn(categories);

    return ResponseEntity.ok().body(list);
  }
}
