package com.bibliotech.model;

public record Libro(
        String isbn,
        String titulo,
        String autor,
        int anio,
        Categoria categoria )  // usamos el enum creado

{
}
// Usamos records primordialmente porque lo pide en la rubrica pero principalmente porque es una clase
// la cual solo va a transportar datos. Es decir los valores no van a cambiar, datos basicos que no van a cambiar
