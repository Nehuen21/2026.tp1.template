package com.bibliotech.service;

import com.bibliotech.exception.EmailInvalidoException;
import com.bibliotech.exception.SocioExistenteExcepcion;
import com.bibliotech.model.Socio;
import com.bibliotech.repository.SocioRepository;

public class SocioService {
    private SocioRepository repositorio = new SocioRepository();

    private boolean esEmailValido(String email){
        return email != null && email.contains("@") && email.indexOf('.')> email.indexOf('@');
    }
    public void registrar(Socio socio){
        if(repositorio.buscarPorDNi(socio.dni()) != null){
            throw new SocioExistenteExcepcion("El dni"+socio.dni() + "ya existe");


        }
        if(!esEmailValido(socio.email())){
            throw new EmailInvalidoException("El email : "+ socio.email()+"No es valido");

        }
        repositorio.guardar(socio);
    }
}
