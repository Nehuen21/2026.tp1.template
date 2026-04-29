package com.bibliotech.repository;

import com.bibliotech.model.Socio;
import com.bibliotech.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SocioRepository {
    private static List<Usuario> lista = new ArrayList<>();
    private static SocioRepository instancia;
    public static SocioRepository getInstancia() {
        if (instancia == null) {
            instancia = new SocioRepository();

        }
        return instancia;
    }

    public void guardar(Usuario usuario){
        lista.add(usuario);

    }
    public Usuario buscarPorDNi(int dni){
        for (Usuario u : lista){
            if (u.dni()== dni) return u;

        }
        return null;
    }
    public List<Usuario> buscarTodos(){
        return new ArrayList<>(lista);
    }
}
