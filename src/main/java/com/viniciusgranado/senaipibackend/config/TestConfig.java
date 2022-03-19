package com.viniciusgranado.senaipibackend.config;

import com.viniciusgranado.senaipibackend.entities.Category;
import com.viniciusgranado.senaipibackend.entities.Product;
import com.viniciusgranado.senaipibackend.entities.User;
import com.viniciusgranado.senaipibackend.repositories.CategoryRepository;
import com.viniciusgranado.senaipibackend.repositories.ProductRepository;
import com.viniciusgranado.senaipibackend.repositories.UserRepository;
import com.viniciusgranado.senaipibackend.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    Category cat1 = new Category(null, "Smartphones", "smartphones");
    Category cat2 = new Category(null, "Laptops", "laptops");
    Category cat3 = new Category(null, "Video Games", "video-games");
    Category cat4 = new Category(null, "Sound", "sound");
    Category cat5 = new Category(null, "Wearables", "wearables");

    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", true);
    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "", false);
    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", true);
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", false);
    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", false);

    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    p1.getCategories().add(cat2);
    p2.getCategories().add(cat1);
    p2.getCategories().add(cat3);
    p3.getCategories().add(cat3);
    p4.getCategories().add(cat3);
    p5.getCategories().add(cat2);

    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "mbrown", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "agreen", "123456");

    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
