package com.viniciusgranado.senaipibackend.repositories;

import com.viniciusgranado.senaipibackend.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
