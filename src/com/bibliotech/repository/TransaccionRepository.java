package com.bibliotech.repository;

import com.bibliotech.model.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class TransaccionRepository {
    private static List<Transaccion> lista = new ArrayList<>();
    private static TransaccionRepository instancia;
    public static TransaccionRepository getInstancia() {
        if (instancia == null) {
            instancia = new TransaccionRepository();

        }
        return instancia;
    }

    public void guardar(Transaccion transaccion){
        lista.add(transaccion);

    }
    public List<Transaccion> buscarPorSocio(int dniSocio){
        List<Transaccion> resultados = new ArrayList<>();
        for (Transaccion t : lista){
            if (t.dniSocio()== dniSocio){
                resultados.add(t);
            }
        }
        return resultados;


    }
    public List<Transaccion> buscarPorLibro(String isbn){
        List<Transaccion> resultados = new ArrayList<>();
        for (Transaccion t : lista){
            if(t.isbn().equals(isbn) ){
                resultados.add(t);
            }
        }
        return resultados;

    }
    public List <Transaccion> buscarTodos(){
        return new ArrayList<>(lista);
    }
}
