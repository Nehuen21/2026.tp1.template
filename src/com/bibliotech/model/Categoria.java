package com.bibliotech.model;

public enum Categoria {
    CIENCIA(1,"Ciencia"),
    HISTORIA(2,"Historia"),
    CIENCIAS_BASICAS(3,"Ciencias basicas"),
    ARTE(4,"ARTE");


    private final int id;
    private final String nombre;
    Categoria(int id,String nombre){
        this.id = id;
        this.nombre = nombre;

    }
    public int getId(){return id;}
    public String getNombre(){return nombre;}
}