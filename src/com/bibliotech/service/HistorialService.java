package com.bibliotech.service;

import com.bibliotech.model.Transaccion;
import com.bibliotech.repository.TransaccionRepository;

import java.util.List;

public class HistorialService {
    private TransaccionRepository repositorio = new TransaccionRepository();

    public void registrarTransaccion(Transaccion transaccion){
        repositorio.guardar(transaccion);
    }
    public List<Transaccion> buscarPorSocio(int dniSocio){
        return repositorio.buscarPorSocio(dniSocio);

    }
    public List<Transaccion> buscarPorLibro(String isbn){
        return repositorio.buscarPorLibro(isbn);
    }
    public List<Transaccion>buscarTodos(){
        return repositorio.buscarTodos();
    }

}




// Aca va a estar toda la logica de las transacciones