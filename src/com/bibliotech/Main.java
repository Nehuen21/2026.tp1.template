package com.bibliotech;

import com.bibliotech.model.Categoria;
import com.bibliotech.model.Ebook;
import com.bibliotech.model.Libro;
import com.bibliotech.model.LibroFisico;
import com.bibliotech.service.LibroService;

public class Main {
    public static void main(String[] args) {
        System.out.println("BiblioTech iniciado.");
        LibroService servicio = new LibroService();
        Libro libro = new Libro("978-3-16-148410-0", "El principito","Antoine de Saint-Exepury",1943, Categoria.ARTE);
        servicio.registrar(libro);
        System.out.println("Libro registrado correctamente ! ");
        LibroFisico fisico = new LibroFisico("978-1","cien años","Garcia marquez",1967,Categoria.ARTE,"bueno","Estanteria A");
        Ebook ebook = new Ebook("978","Percy Jackson","Facundo Lucero",2010,Categoria.CIENCIA,"PDF", 500000L);

        servicio.registrar(fisico);
        servicio.registrar(ebook);
    }
}



// java -cp out com.bibliotech.Main