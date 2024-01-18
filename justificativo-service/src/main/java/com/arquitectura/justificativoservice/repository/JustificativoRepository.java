package com.arquitectura.justificativoservice.repository;

import com.arquitectura.justificativoservice.entity.Justificativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificativoRepository extends JpaRepository<Justificativo, Integer> {
}
