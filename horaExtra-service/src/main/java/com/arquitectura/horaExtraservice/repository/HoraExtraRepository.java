package com.arquitectura.horaExtraservice.repository;

import com.arquitectura.horaExtraservice.entity.HoraExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraExtraRepository extends JpaRepository<HoraExtra, Integer> {
}
