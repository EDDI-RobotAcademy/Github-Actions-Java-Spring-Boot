package com.example.demo.selfSalad.repository;

import com.example.demo.selfSalad.entity.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountRepository extends JpaRepository<Amount, Long> {
}
