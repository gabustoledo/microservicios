package com.arquitectura.calcularservice.service;

import com.arquitectura.calcularservice.entity.UserEntity;
import com.arquitectura.calcularservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity user) {
        UserEntity userNew = userRepository.save(user);
        return userNew;
    }

    public boolean delete(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
