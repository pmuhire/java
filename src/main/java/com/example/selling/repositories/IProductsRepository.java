package com.example.selling.repositories;

import com.example.selling.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductsRepository  extends JpaRepository<Product,Long> {
    Optional<Product> findByCode(String code);
}
