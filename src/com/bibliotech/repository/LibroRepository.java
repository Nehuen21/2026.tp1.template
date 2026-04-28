package com.bibliotech.repository;
import com.bibliotech.model.Recurso;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.bibliotech.model.Categoria;

public class LibroRepository {
    private final List<Recurso> lista = new ArrayList<>();

    public void guardar(Recurso recurso) {
        lista.add(recurso);
    }

    public Recurso buscarPorId(String isbn) {
        for (Recurso r : lista) {
            if (r.isbn().equals(isbn)) return r;
        }
        return null;
    }

    public List<Recurso> buscarTodos() {
        return new ArrayList<>(lista);
    }

    public List<Recurso> buscarPorTitulo(String titulo) {
        List<Recurso> resultados = new ArrayList<>();
        for (Recurso r : lista) {
            if (r.titulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(r);
            }
        }
        return resultados;

    }

    public List<Recurso> buscarPorAutor(String autor) {
        List<Recurso> resultados = new ArrayList<>();
        for (Recurso r : lista) {
            if (r.autor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(r);

            }

        }
        return resultados;
    }

    public List<Recurso> buscarPorCategoria(Categoria categoria) {
        List<Recurso> resultados = new ArrayList<>();
        for (Recurso r : lista) {
            if (r.categoria().equals(categoria)){
                resultados.add(r);}
        }
        return resultados;
    }

}

// Agregar métodos de búsqueda en `LibroRepository` (buscarPorTitulo, buscarPorAutor, buscarPorCategoria)

