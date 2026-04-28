package com.bibliotech.model;

public record Estudiante(
        int dni,
        String nombre,
        String email,
        TipoSocio tipo

) implements Usuario{
}
