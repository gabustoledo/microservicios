package com.arquitectura.calcularservice.repository;

import com.arquitectura.calcularservice.entity.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SueldoRepository extends JpaRepository<Sueldo, Integer> {
}
