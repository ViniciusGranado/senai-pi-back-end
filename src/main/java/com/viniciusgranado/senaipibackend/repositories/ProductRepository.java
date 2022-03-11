package com.viniciusgranado.senaipibackend.repositories;

import com.viniciusgranado.senaipibackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
