package com.bibliotech.model;

import java.time.LocalDate;

public record Transaccion(
        int id,
        String isbn,
        int dniSocio,
        TipoTransaccion tipo,
        LocalDate fecha
) {
}
