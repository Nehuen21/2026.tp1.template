package com.bibliotech;

import com.bibliotech.exception.EmailInvalidoException;
import com.bibliotech.model.*;
import com.bibliotech.service.LibroService;
import com.bibliotech.service.SocioService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("BiblioTech iniciado.");
        // servicios
        LibroService servicio = new LibroService();
        SocioService socioService = new SocioService();


        Libro libro = new Libro("978-3-16-148410-0", "El principito","Antoine de Saint-Exepury",1943, Categoria.ARTE);
        servicio.registrar(libro);
        System.out.println("Libro registrado correctamente ! ");
        LibroFisico fisico = new LibroFisico("978-1","cien años","Garcia marquez",1967,Categoria.ARTE,"bueno","Estanteria A");
        Ebook ebook = new Ebook("978","Percy Jackson","Facundo Lucero",2010,Categoria.CIENCIA,"PDF", 500000L);
        // registrar libro
        servicio.registrar(fisico);
        servicio.registrar(ebook);

        List<Recurso> resultadosTitulo = servicio.buscarPorTitulo("El principito");
        System.out.println("por titulo" + resultadosTitulo);

        List<Recurso> resultadosAutor = servicio.buscarPorAutor("Facundo Lucero");
        System.out.println("por Autor" + resultadosAutor);

        List<Recurso> resultadosCategoria = servicio.buscarPorCategoria(Categoria.ARTE);
        System.out.println("por categoria" + resultadosCategoria);




        Socio socio1 = new Socio(12345678,"Nehuen donozo","Nehuen@gmail.com",TipoSocio.ESTUDIANTE);
        socioService.registrar(socio1);
        System.out.println("Socio registrado"+socio1);

        try{
            Socio socio2 = new Socio(328183,"maria","emailsinarroba",TipoSocio.DOCENTE);
            socioService.registrar(socio2);

        } catch (EmailInvalidoException e){
            System.out.println("Email invalido" + e.getMessage() );
        }


    }

}



// java -cp out com.bibliotech.Main