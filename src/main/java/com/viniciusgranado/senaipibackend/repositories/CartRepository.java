package com.viniciusgranado.senaipibackend.repositories;

import com.viniciusgranado.senaipibackend.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
