package com.argentina.programa.shroot91.integrador;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private List<Pronostico> pronosticos;
    private int puntaje;

    public Persona() {
        nombre = "";
        puntaje=0;
        pronosticos = new ArrayList<Pronostico>(); // toma la estructura de pronostico
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<Pronostico>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object nombre) {
        return this.nombre == nombre;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public void addPronostico(Pronostico pronostico) {
        this.pronosticos.add(pronostico);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public void añadirPuntos(int puntos){
        this.puntaje+=puntos;
    }
}
