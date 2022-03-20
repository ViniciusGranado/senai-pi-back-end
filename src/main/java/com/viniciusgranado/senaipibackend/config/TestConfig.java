package com.viniciusgranado.senaipibackend.config;

import com.viniciusgranado.senaipibackend.entities.*;
import com.viniciusgranado.senaipibackend.entities.enums.Roles;
import com.viniciusgranado.senaipibackend.repositories.*;
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

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private CartItemRepository cartItemRepository;

  @Override
  public void run(String... args) throws Exception {
    Category cat1 = new Category(null, "Smartphones", "smartphones");
    Category cat2 = new Category(null, "Laptops", "laptops");
    Category cat3 = new Category(null, "Video Games", "video-games");
    Category cat4 = new Category(null, "Sound", "sound");
    Category cat5 = new Category(null, "Wearables", "wearables");

    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SX679_.jpg", true);
    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SX679_.jpg", false);
    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SX679_.jpg", true);
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SX679_.jpg", false);
    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SX679_.jpg", false);

    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    p1.getCategories().add(cat2);
    p2.getCategories().add(cat1);
    p2.getCategories().add(cat3);
    p3.getCategories().add(cat3);
    p4.getCategories().add(cat3);
    p5.getCategories().add(cat2);

    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "mbrown", "123456", Roles.valueOf("COMMON"));
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "agreen", "123456",  Roles.valueOf("ADMIN"));

    userRepository.saveAll(Arrays.asList(u1, u2));

    Cart c1 = new Cart(null, u1);
    Cart c2 = new Cart(null, u2);

    cartRepository.saveAll(Arrays.asList(c1, c2));

    CartItem ci1 = new CartItem(c1, p1, 2, p1.getPrice());
    CartItem ci2 = new CartItem(c1, p2, 2, p2.getPrice());
    CartItem ci3 = new CartItem(c1, p3, 2, p3.getPrice());
    CartItem ci4 = new CartItem(c1, p4, 2, p4.getPrice());
    CartItem ci5 = new CartItem(c1, p5, 2, p5.getPrice());
    CartItem ci6 = new CartItem(c2, p1, 2, p1.getPrice());
    CartItem ci7 = new CartItem(c2, p2, 2, p2.getPrice());
    CartItem ci8 = new CartItem(c2, p3, 2, p3.getPrice());
    CartItem ci9 = new CartItem(c2, p4, 2, p4.getPrice());

    cartItemRepository.saveAll(Arrays.asList(ci1, ci2, ci3, ci4, ci5, ci6, ci7, ci8, ci9));
  }
}
