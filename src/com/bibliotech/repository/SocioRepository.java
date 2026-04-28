package com.bibliotech.repository;

import com.bibliotech.model.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioRepository {
    private List<Socio> lista = new ArrayList<>();

    public void guardar(Socio socio){
        lista.add(socio);

    }
    public Socio buscarPorDNi(int dni){
        for (Socio s : lista){
            if (s.dni()== dni) return s;

        }
        return null;
    }
    public List<Socio> buscarTodos(){
        return new ArrayList<>(lista);
    }
}
