package com.arquitectura.calcularservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoraExtra {
    private int id;
    private String user_rut;
    private String fecha;
    private int cantidad;
}
