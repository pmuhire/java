package com.example.selling.repositories;

import com.example.selling.models.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchasedRepository extends JpaRepository<Purchased,Long> {
}
