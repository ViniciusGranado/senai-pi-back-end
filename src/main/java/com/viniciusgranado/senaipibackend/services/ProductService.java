package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.repositories.ProductRepository;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(Long id) {
    try {
      Optional<Product> obj = repository.findById(id);

      return obj.get();
    } catch (NoSuchElementException e) {
      throw new ResourceNotFoundException(id);
    }
  }
}
