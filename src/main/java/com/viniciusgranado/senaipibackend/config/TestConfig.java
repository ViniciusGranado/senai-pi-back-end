package com.viniciusgranado.senaipibackend.config;

import com.viniciusgranado.senaipibackend.entities.Cart;
import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.entities.enums.Roles;
import com.viniciusgranado.senaipibackend.repositories.CartRepository;
import com.viniciusgranado.senaipibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CartRepository cartRepository;

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "admin", "admin", "admin", "admin", Roles.valueOf("ADMIN"));

    userRepository.save(u1);

    Cart c1 = new Cart(null, u1);

    cartRepository.save(c1);
  }
}
