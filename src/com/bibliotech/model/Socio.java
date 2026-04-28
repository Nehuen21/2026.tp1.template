package com.bibliotech.model;

public record Socio(
        int dni,
        String nombre,
        String email,
        TipoSocio tipo
) {
}



// Decision de diseño: Creamos a Socio como un record por consistencia ya que Libro,LibroFisico,Ebook tambien son records
// Socio es una entindad simple la cual solo va a transportar datos