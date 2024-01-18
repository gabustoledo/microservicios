package com.arquitectura.reporteservice.service;

import com.arquitectura.reporteservice.entity.SueldoFilter;
import com.arquitectura.reporteservice.model.Sueldo;
import com.arquitectura.reporteservice.repository.SueldoFilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SueldoFilterService {

    @Autowired
    SueldoFilterRepository sueldoFilterRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<SueldoFilter> getAll() {
        return sueldoFilterRepository.findAll();
    }

    public SueldoFilter getById(int id) {
        return sueldoFilterRepository.findById(id).orElse(null);
    }

    public SueldoFilter save(SueldoFilter sueldo) {
        SueldoFilter sueldoNew = sueldoFilterRepository.save(sueldo);
        return sueldoNew;
    }

    public boolean delete(int id) {
        try {
            sueldoFilterRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public void deleteAll() {
        ArrayList<SueldoFilter> sueldos = (ArrayList<SueldoFilter>) sueldoFilterRepository.findAll();

        for (SueldoFilter sueldo : sueldos) {
            sueldoFilterRepository.deleteById(sueldo.getId());
        }
    }

    public List<Sueldo> getSueldo(){
        List<Sueldo> sueldos = restTemplate.getForObject("http://localhost:8080/calcular", List.class);
        return sueldos;
    }
//
//    public List<Justificativo> getJustificativo(){
//        List<Justificativo> justificativos = restTemplate.getForObject("http://localhost:8080/justificativo", List.class);
//        return justificativos;
//    }
//
//    public List<HoraExtra> getHoraExtra(){
//        List<HoraExtra> horaExtras = restTemplate.getForObject("http://localhost:8080/horaExtra", List.class);
//        return horaExtras;
//    }
}
