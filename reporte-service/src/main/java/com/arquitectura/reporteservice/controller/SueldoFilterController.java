package com.arquitectura.reporteservice.controller;

import com.arquitectura.reporteservice.entity.SueldoFilter;
import com.arquitectura.reporteservice.model.Sueldo;
import com.arquitectura.reporteservice.service.SueldoFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/reporte")
public class SueldoFilterController {

    @Autowired
    SueldoFilterService sueldoFilterService;

    @GetMapping
    public List<Sueldo> getAll() {
        List<Sueldo> sueldos = sueldoFilterService.getSueldo();
//        if(sueldos.isEmpty())
//            return ResponseEntity.noContent().build();
        return sueldos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SueldoFilter> getById(@PathVariable("id") int id) {
        SueldoFilter sueldo = sueldoFilterService.getById(id);
        if(sueldo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sueldo);
    }

    @PostMapping()
    public ResponseEntity<SueldoFilter> save(@RequestBody SueldoFilter sueldo) {
        SueldoFilter sueldoNew = sueldoFilterService.save(sueldo);
        return ResponseEntity.ok(sueldoNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id){
        boolean isRemoved = sueldoFilterService.delete(id);

        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
