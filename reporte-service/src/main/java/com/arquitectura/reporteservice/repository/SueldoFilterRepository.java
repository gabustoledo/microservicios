package com.arquitectura.reporteservice.repository;

import com.arquitectura.reporteservice.entity.SueldoFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SueldoFilterRepository extends JpaRepository<SueldoFilter, Integer> {
}
