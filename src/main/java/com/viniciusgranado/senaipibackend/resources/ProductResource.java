package com.viniciusgranado.senaipibackend.resources;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.entities.dtos.NewProductDto;
import com.viniciusgranado.senaipibackend.services.CategoryService;
import com.viniciusgranado.senaipibackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping(value = "/favorites")
  public ResponseEntity<List<Product>> findAllByIsFavorite() {
    List<Product> list = productService.findAllByIsFavorite();

    return ResponseEntity.ok().body(list);
  }

  @PostMapping
  public ResponseEntity<Product> insert(@RequestBody NewProductDto newProduct) {
    Product product = new Product(
            null,
            newProduct.getName(),
            newProduct.getDescription(),
            newProduct.getPrice(),
            newProduct.getImgUrl(),
            newProduct.isFavorite()
    );

    for (Category category : newProduct.getCategories()) {
      product.getCategories().add(category);
    }

    productService.insert(product);

    return ResponseEntity.ok().body(product);
  }
}
