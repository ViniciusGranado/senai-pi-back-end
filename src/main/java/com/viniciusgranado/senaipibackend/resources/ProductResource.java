package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.services.CategoryService;
import com.viniciusgranado.senaipibackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> list = productService.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product obj = productService.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @GetMapping(value = "/category/{categoryReference}")
  public ResponseEntity<List<Product>> findAllByCategoriesIn(@PathVariable String categoryReference) {
    Category category = categoryService.findByReference(categoryReference);
    Set<Category> categorySet = new HashSet<>(List.of(category));

    List<Product> list = productService.findAllByCategoriesIn(categorySet);

    return ResponseEntity.ok().body(list);
  }
}
