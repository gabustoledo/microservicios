package com.arquitectura.calcularservice.controller;

import com.arquitectura.calcularservice.entity.Horario;
import com.arquitectura.calcularservice.entity.Sueldo;
import com.arquitectura.calcularservice.entity.UserEntity;
import com.arquitectura.calcularservice.model.CalculoSueldo;
import com.arquitectura.calcularservice.model.HoraExtra;
import com.arquitectura.calcularservice.model.Justificativo;
import com.arquitectura.calcularservice.service.SueldoService;
import com.arquitectura.calcularservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/calcular")
public class SueldoController {

    @Autowired
    SueldoService sueldoService;

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    public List<Sueldo> getAll() {
        List<Sueldo> sueldos = sueldoService.getAll();
//        if(sueldos.isEmpty())
//            return ResponseEntity.noContent().build();
        return sueldos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sueldo> getById(@PathVariable("id") int id) {
        Sueldo sueldo = sueldoService.getById(id);
        if(sueldo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sueldo);
    }

    @PostMapping()
    public ResponseEntity<Sueldo> save(@RequestBody Sueldo sueldo) {
        Sueldo sueldoNew = sueldoService.save(sueldo);
        return ResponseEntity.ok(sueldoNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id){
        boolean isRemoved = sueldoService.delete(id);

        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/sueldo")
    public ResponseEntity<Integer> calcular() throws ParseException {

        // Obtengo horarios y los dejo en una lista formateados en objeto horario
        List<Horario> horariosJSON = sueldoService.getHorario();
        List<Horario> horarios = new ArrayList<Horario>();
        for(int i=0; i< horariosJSON.size();i++){

            String content = String.valueOf(horariosJSON.get(i));

            String replace = content.replace("{","");
            String replace1 = replace.replace("}","");
            String replace2 = replace1.replace("fecha=", "");
            String replace3 = replace2.replace("hora=", "");
            String replace4 = replace3.replace("id=", "");
            String replace5 = replace4.replace("user_rut=", "");
            String replace6 = replace5.replace(" ", "");
            List<String> element = new ArrayList<>(Arrays.asList(replace6.split(",")));

            int id = Integer.parseInt(element.get(0));
            String user_rut = element.get(1);
            String fecha = element.get(2);
            String hora = element.get(3);
            Horario horarioAux = new Horario(id,user_rut,fecha,hora);
            horarios.add(horarioAux);
        }

        // Obtengo usuarios, ya son entregados en lista de objetos
        List<UserEntity> users = userService.getAll();

        // Obtengo horas extras y los dejo en una lista formateados en objeto horaExtra
        List<HoraExtra> horaExtrasJSON = sueldoService.getHoraExtra();
        List<HoraExtra> horaExtras = new ArrayList<HoraExtra>();
        for(int i=0; i< horaExtrasJSON.size();i++){

            String content = String.valueOf(horaExtrasJSON.get(i));

            String replace = content.replace("{","");
            String replace1 = replace.replace("}","");
            String replace2 = replace1.replace("fecha=", "");
            String replace3 = replace2.replace("cantidad=", "");
            String replace4 = replace3.replace("id=", "");
            String replace5 = replace4.replace("user_rut=", "");
            String replace6 = replace5.replace(" ", "");
            List<String> element = new ArrayList<>(Arrays.asList(replace6.split(",")));

            int id = Integer.parseInt(element.get(0));
            String user_rut = element.get(1);
            String fecha = element.get(2);
            int cantidad = Integer.parseInt(element.get(3));

            HoraExtra horaExtraAux = new HoraExtra(id,user_rut,fecha,cantidad);
            horaExtras.add(horaExtraAux);
        }

        // Obtengo justificativos y los dejo en una lista formateados en objeto justificativo
        List<Justificativo> justificativosJSON = sueldoService.getJustificativo();
        List<Justificativo> justificativos = new ArrayList<Justificativo>();
        for(int i=0; i< justificativosJSON.size();i++){

            String content = String.valueOf(justificativosJSON.get(i));

            String replace = content.replace("{","");
            String replace1 = replace.replace("}","");
            String replace2 = replace1.replace("fecha=", "");
            String replace3 = replace2.replace("id=", "");
            String replace4 = replace3.replace("user_rut=", "");
            String replace5 = replace4.replace(" ", "");
            List<String> element = new ArrayList<>(Arrays.asList(replace5.split(",")));

            int id = Integer.parseInt(element.get(0));
            String user_rut = element.get(1);
            String fecha = element.get(2);

            Justificativo justificativoAux = new Justificativo(id,user_rut,fecha);
            justificativos.add(justificativoAux);
        }

        // ya se tienen todos los objetos, ahora crear un metodo y aqui solo realizar el llamado.
        List<Sueldo> sueldos = CalculoSueldo.calculoSueldo(horarios,users,justificativos,horaExtras);

        // Borrar todos los sueldos de la base de datos
        sueldoService.deleteAll();

        // Guardar sueldos de funcion
        for(Sueldo sueldo : sueldos){
            sueldoService.save(sueldo);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
