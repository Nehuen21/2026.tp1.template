package com.bibliotech.service;

import com.bibliotech.exception.LibroExistenteException;
import com.bibliotech.model.Libro;
import com.bibliotech.repository.LibroRepository;

public class LibroService {
    private LibroRepository repositorio = new LibroRepository();
    public void registrar(Libro libro ){

        if (repositorio.buscarPorId(libro.isbn()) != null){
            throw new LibroExistenteException("El ISBN"+ libro.isbn() + "Ya existe");
        }
        if (libro.isbn() == null || libro.isbn().isBlank()){
            throw new IllegalArgumentException("El isbn no puede estar vacio");

              }
        repositorio.guardar(libro);
    }

}   

// La logica va a ser
// 1. Verificar si el ISBN ya existe en el repositorio --> si existe, lanzamos una expecion en este caso
// LibroExistenteException
// 2. SI no existe, validar el formato del isbn (Ej: no vacio, largo, con caracteres razonables)
// 3. Si todo esta OK lo guardo en el repositorio