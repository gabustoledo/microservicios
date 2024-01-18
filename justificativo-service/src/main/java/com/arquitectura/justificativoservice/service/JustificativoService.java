package com.arquitectura.justificativoservice.service;

import com.arquitectura.justificativoservice.entity.Justificativo;
import com.arquitectura.justificativoservice.repository.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JustificativoService {

    @Autowired
    JustificativoRepository justificativoRepository;

    public List<Justificativo> getAll() {
        return justificativoRepository.findAll();
    }

    public Justificativo getById(int id) {
        return justificativoRepository.findById(id).orElse(null);
    }

    public Justificativo save(Justificativo justificativo) {
        Justificativo justificativoNew = justificativoRepository.save(justificativo);
        return justificativoNew;
    }

    public boolean delete(int id) {
        try {
            justificativoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
