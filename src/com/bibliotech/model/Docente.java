package com.bibliotech.model;

public record Docente(
        int dni,
        String nombre,
        String email,
        TipoSocio tipo
) implements Usuario{
}
