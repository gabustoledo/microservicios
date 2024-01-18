package com.arquitectura.importarservice.service;

import com.arquitectura.importarservice.entity.Horario;
import com.arquitectura.importarservice.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    HorarioRepository horarioRepository;

    public List<Horario> getAll() {
        return horarioRepository.findAll();
    }

    public Horario getById(int id) {
        return horarioRepository.findById(id).orElse(null);
    }

    public Horario save(Horario horario) {
        Horario horarioNew = horarioRepository.save(horario);
        return horarioNew;
    }

    public boolean delete(int id) {
        try {
            horarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public void deleteAll() {
        ArrayList<Horario> horarios = (ArrayList<Horario>) horarioRepository.findAll();

        for (Horario horario : horarios) {
            horarioRepository.deleteById(horario.getId());
        }
    }
}
