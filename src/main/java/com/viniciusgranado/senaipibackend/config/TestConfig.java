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

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderItemRepository orderItemRepository;

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

    Order o1 = new Order(null, u1);
    Order o2 = new Order(null, u2);
    Order o3 = new Order(null, u1);

    orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
    OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
    OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
    OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

    orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
  }
}
