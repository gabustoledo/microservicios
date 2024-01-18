package com.arquitectura.importarservice.controller;

import com.arquitectura.importarservice.entity.Horario;
import com.arquitectura.importarservice.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    HorarioService horarioService;

    @GetMapping
    public ResponseEntity<List<Horario>> getAll() {
        List<Horario> horarios = horarioService.getAll();
        if(horarios.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getById(@PathVariable("id") int id) {
        Horario horario = horarioService.getById(id);
        if(horario == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(horario);
    }

    @PostMapping()
    public ResponseEntity<Horario> save(@RequestBody Horario horario) {
        Horario horarioNew = horarioService.save(horario);
        return ResponseEntity.ok(horarioNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id){
        boolean isRemoved = horarioService.delete(id);

        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
