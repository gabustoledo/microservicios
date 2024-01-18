package com.arquitectura.reporteservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SueldoFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_rut;
    private String nombre;
    private String apellido;
    private String categoria;
    private int tiempoServicio;
    private String area;
    private int sueldoFijo;
    private int bonoHorasExtras;
    private int bonoTiempoServicio;
    private int bonoPuntualidad;
    private int descuentoIngreso;
    private int descuentoSalida;
    private int sueldoBruto;
    private int prevision;
    private int salud;
    private int sueldoFinal;
}
