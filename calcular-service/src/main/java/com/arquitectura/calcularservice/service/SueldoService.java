package com.arquitectura.calcularservice.service;

import com.arquitectura.calcularservice.entity.Horario;
import com.arquitectura.calcularservice.entity.Sueldo;
import com.arquitectura.calcularservice.model.HoraExtra;
import com.arquitectura.calcularservice.model.Justificativo;
import com.arquitectura.calcularservice.repository.SueldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SueldoService {

    @Autowired
    SueldoRepository sueldoRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Sueldo> getAll() {
        return sueldoRepository.findAll();
    }

    public Sueldo getById(int id) {
        return sueldoRepository.findById(id).orElse(null);
    }

    public Sueldo save(Sueldo sueldo) {
        Sueldo sueldoNew = sueldoRepository.save(sueldo);
        return sueldoNew;
    }

    public boolean delete(int id) {
        try {
            sueldoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public void deleteAll() {
        ArrayList<Sueldo> sueldos = (ArrayList<Sueldo>) sueldoRepository.findAll();

        for (Sueldo sueldo : sueldos) {
            sueldoRepository.deleteById(sueldo.getId());
        }
    }

    public List<Horario> getHorario(){
        List<Horario> horarios = restTemplate.getForObject("http://localhost:8080/horario", List.class);
        return horarios;
    }

    public List<Justificativo> getJustificativo(){
        List<Justificativo> justificativos = restTemplate.getForObject("http://localhost:8080/justificativo", List.class);
        return justificativos;
    }

    public List<HoraExtra> getHoraExtra(){
        List<HoraExtra> horaExtras = restTemplate.getForObject("http://localhost:8080/horaExtra", List.class);
        return horaExtras;
    }
}
