package com.example.selling.repositories;

import com.example.selling.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductsRepository  extends JpaRepository<Product,Long> {
}
