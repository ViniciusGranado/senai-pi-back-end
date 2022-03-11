package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.repositories.CategoryRepository;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository repository;

  public List<Category> findAll() {
    return repository.findAll();
  }

  public Category findById(Long id) {
    try {
      Optional<Category> obj = repository.findById(id);

      return obj.get();
    } catch (NoSuchElementException e) {
      throw new ResourceNotFoundException(id);
    }
  }
}
