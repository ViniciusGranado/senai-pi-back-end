package com.viniciusgranado.senaipibackend.repositories;

import com.viniciusgranado.senaipibackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
