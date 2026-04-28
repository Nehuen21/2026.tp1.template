package com.bibliotech.model;

public record LibroFisico(
        String isbn,
        String titulo,
        String autor,
        int anio,
        Categoria categoria,
        String condicion,
        String ubicacion




) implements Recurso {
}



// Decision de diseño : Al tratar LibroFisico como record no podemos tratar la herencia. Por lo que vamos
// a duplicar los atributos, para que de igual forma cada uno pueda implementar recurso (polimorfismo)