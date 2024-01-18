package com.arquitectura.horaExtraservice.service;

import com.arquitectura.horaExtraservice.entity.HoraExtra;
import com.arquitectura.horaExtraservice.repository.HoraExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoraExtraService {

    @Autowired
    HoraExtraRepository horaExtraRepository;

    public List<HoraExtra> getAll() {
        return horaExtraRepository.findAll();
    }

    public HoraExtra getById(int id) {
        return horaExtraRepository.findById(id).orElse(null);
    }

    public HoraExtra save(HoraExtra horaExtra) {
        HoraExtra horaExtraNew = horaExtraRepository.save(horaExtra);
        return horaExtraNew;
    }

    public boolean delete(int id) {
        try {
            horaExtraRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
