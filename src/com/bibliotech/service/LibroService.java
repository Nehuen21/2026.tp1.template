package com.bibliotech.service;
import com.bibliotech.exception.LibroExistenteException;
import com.bibliotech.model.Recurso;
import com.bibliotech.repository.LibroRepository;

public class LibroService {
    private LibroRepository repositorio = new LibroRepository();
    public void registrar(Recurso recurso ){

        if (repositorio.buscarPorId(recurso.isbn()) != null){
            throw new LibroExistenteException("El ISBN"+ recurso.isbn() + "Ya existe");
        }
        if (recurso.isbn() == null || recurso.isbn().isBlank()){
            throw new IllegalArgumentException("El isbn no puede estar vacio");

              }
        repositorio.guardar(recurso);
    }

}

// La logica va a ser
// 1. Verificar si el ISBN ya existe en el repositorio --> si existe, lanzamos una expecion en este caso
// LibroExistenteException
// 2. SI no existe, validar el formato del isbn (Ej: no vacio, largo, con caracteres razonables)
// 3. Si todo esta OK lo guardo en el repositorio