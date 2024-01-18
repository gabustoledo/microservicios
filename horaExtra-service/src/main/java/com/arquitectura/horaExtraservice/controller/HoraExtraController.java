package com.arquitectura.horaExtraservice.controller;

import com.arquitectura.horaExtraservice.entity.HoraExtra;
import com.arquitectura.horaExtraservice.service.HoraExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/horaExtra")
public class HoraExtraController {

    @Autowired
    HoraExtraService horaExtraService;

    @GetMapping
    public ResponseEntity<List<HoraExtra>> getAll() {
        List<HoraExtra> horaExtras = horaExtraService.getAll();
        if(horaExtras.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(horaExtras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoraExtra> getById(@PathVariable("id") int id) {
        HoraExtra horaExtra = horaExtraService.getById(id);
        if(horaExtra == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(horaExtra);
    }

    @PostMapping()
    public ResponseEntity<HoraExtra> save(@RequestBody HoraExtra HoraExtra) {
        HoraExtra horaExtraNew = horaExtraService.save(HoraExtra);
        return ResponseEntity.ok(horaExtraNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id){
        boolean isRemoved = horaExtraService.delete(id);

        if(!isRemoved){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
