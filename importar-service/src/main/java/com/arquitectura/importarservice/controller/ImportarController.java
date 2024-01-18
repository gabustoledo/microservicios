package com.arquitectura.importarservice.controller;

import com.arquitectura.importarservice.entity.File;
import com.arquitectura.importarservice.entity.Horario;
import com.arquitectura.importarservice.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/importar")
public class ImportarController {

    @Autowired
    HorarioService horarioService;

    @GetMapping
    public ResponseEntity<Integer> getAll() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> readFiles(@RequestParam("fileJSON") MultipartFile fileJSON, @RequestParam("fileTXT") MultipartFile fileTXT) throws IOException {
        horarioService.deleteAll();

        File fileHandler = new File();
        List<Horario> horariosTXT = fileHandler.readFileTXT(fileTXT);
        List<Horario> horariosJSON = fileHandler.readFileJSON(fileJSON);

        for(Horario horario : horariosTXT){
            horarioService.save(horario);
        }

        for(Horario horario : horariosJSON){
            horarioService.save(horario);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
