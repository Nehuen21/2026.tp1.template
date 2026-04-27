package com.bibliotech;

import com.bibliotech.model.Categoria;
import com.bibliotech.model.Libro;
import com.bibliotech.service.LibroService;

public class Main {
    public static void main(String[] args) {
        System.out.println("BiblioTech iniciado.");
        LibroService servicio = new LibroService();
        Libro libro = new Libro("978-3-16-148410-0", "El principito","Antoine de Saint-Exepury",1943, Categoria.ARTE);
        servicio.registrar(libro);
        System.out.println("Libro registrado correctamente ! ");
    }
}


// java -cp out com.bibliotech.Main