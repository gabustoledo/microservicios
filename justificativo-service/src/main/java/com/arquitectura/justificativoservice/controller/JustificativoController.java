package com.arquitectura.justificativoservice.controller;

import com.arquitectura.justificativoservice.entity.Justificativo;
import com.arquitectura.justificativoservice.service.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/justificativo")
public class JustificativoController {

    @Autowired
    JustificativoService justificativoService;

    @GetMapping
    public ResponseEntity<List<Justificativo>> getAll() {
        List<Justificativo> justificativos = justificativoService.getAll();
        if(justificativos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(justificativos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Justificativo> getById(@PathVariable("id") int id) {
        Justificativo justificativo = justificativoService.getById(id);
        if(justificativo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(justificativo);
    }

    @PostMapping()
    public ResponseEntity<Justificativo> save(@RequestBody Justificativo justificativo) {
        Justificativo justificativoNew = justificativoService.save(justificativo);
        return ResponseEntity.ok(justificativoNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id){
        boolean isRemoved = justificativoService.delete(id);

        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
