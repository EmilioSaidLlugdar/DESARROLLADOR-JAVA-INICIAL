package org.example.integrador;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private int nro;
    private List<Partido> partidos; //listado para trabajar mas dinamico

    public Ronda() {
    }

    public Ronda(int nro) {
        this.nro = nro;
        this.partidos = new ArrayList<Partido>();
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }


    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    // cada ronda puede tener 1 o mas partido
    // es por eso que definimos este metodo
    public void agregarPartido(Partido partido) {
        this.partidos.add(partido);
    }
}
