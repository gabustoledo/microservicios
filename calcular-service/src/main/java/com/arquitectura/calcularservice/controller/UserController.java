package com.arquitectura.calcularservice.controller;

import com.arquitectura.calcularservice.entity.UserEntity;
import com.arquitectura.calcularservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity> users = userService.getAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable("id") int id) {
        UserEntity user = userService.getById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
        UserEntity userew = userService.save(user);
        return ResponseEntity.ok(userew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id){
        boolean isRemoved = userService.delete(id);

        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
