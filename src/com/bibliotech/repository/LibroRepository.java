package com.bibliotech.repository;
import com.bibliotech.model.Recurso;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {
    private final List<Recurso> lista = new ArrayList<>();
    public void guardar(Recurso recurso){
        lista.add(recurso);
    }
    public Recurso buscarPorId(String isbn){
        for (Recurso r : lista){
            if (r.isbn().equals(isbn))return r ;
        }
        return null;
    }
    public List<Recurso> buscarTodos(){
        return new ArrayList<>(lista);
    }

}




