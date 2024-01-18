package com.arquitectura.calcularservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    private int id;
    private String user_rut;
    private String fecha;
    private String hora;
}
