package com.bibliotech.repository;
import com.bibliotech.model.Libro;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {
    private final List<Libro> lista = new ArrayList<>();
    public void guardar(Libro libro){
        lista.add(libro);
    }
    public Libro buscarPorId(String isbn){
        for (Libro l : lista){
            if (l.isbn().equals(isbn))return l ;
        }
        return null;
    }
    public List<Libro> buscarTodos(){
        return new ArrayList<>(lista);
    }

}



// UN repository es una clase que maneja el acceso a datos. es una capa entre el Service (logica de negocioy el almacenamiento
// (memoria,base de datos,archivo)

// SU proposito es:
// centralizar operaciones crud
// Abstraer como se almacenan los datos
// EL service no sabe si los datos vienen de una lista en memoria, bd etc
