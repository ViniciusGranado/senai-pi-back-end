package com.viniciusgranado.senaipibackend.services;

import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.repositories.UserRepository;
import com.viniciusgranado.senaipibackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);

    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return repository.save(obj);
  }
}
