package com.arquitectura.reporteservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sueldo {
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
    private String fechaIngreso;
    private int diasTrabajados;
    private int ingresoPuntual;
    private int salidaPuntual;
    private int porcentajeIngreso;
    private int porcentajeSalida;
}
