package com.bibliotech.service;

import com.bibliotech.exception.EmailInvalidoException;
import com.bibliotech.exception.SocioExistenteExcepcion;
import com.bibliotech.model.Socio;
import com.bibliotech.model.Usuario;
import com.bibliotech.repository.SocioRepository;

public class SocioService {
    private SocioRepository repositorio = new SocioRepository();

    private boolean esEmailValido(String email){
        return email != null && email.contains("@") && email.indexOf('.')> email.indexOf('@');
    }
    public void registrar(Usuario usuario){

        if(repositorio.buscarPorDNi(usuario.dni()) != null){
            throw new SocioExistenteExcepcion("El dni"+usuario.dni() + "ya existe");


        }
        if(!esEmailValido(usuario.email())){
            throw new EmailInvalidoException("El email : "+ usuario.email()+"No es valido");

        }
        repositorio.guardar(usuario);
    }
}
