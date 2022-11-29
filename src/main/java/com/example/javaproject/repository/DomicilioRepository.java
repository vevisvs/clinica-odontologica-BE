package com.example.javaproject.repository;

import com.example.javaproject.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
