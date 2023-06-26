package com.example.selling.repositories;

import com.example.selling.models.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuantityRepository extends JpaRepository<Quantity,Long> {
}
