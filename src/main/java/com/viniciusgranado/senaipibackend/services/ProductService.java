package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.repositories.CategoryRepository;
import com.viniciusgranado.senaipibackend.repositories.ProductRepository;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;
  private CategoryRepository categoryRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    try {
      Optional<Product> obj = productRepository.findById(id);

      return obj.get();
    } catch (NoSuchElementException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  public List<Product> findAllByCategoriesIn(Set<Category> categories) {
    return productRepository.findAllByCategoriesIn(categories);
  }

  public List<Product> findAllByIsFavorite() {
    return productRepository.findAllByIsFavorite(true);
  }

  public Product insert(Product obj) {
    return productRepository.save(obj);
  }
}
