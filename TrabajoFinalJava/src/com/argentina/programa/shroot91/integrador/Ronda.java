package com.argentina.programa.shroot91.integrador;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private int nro;
    private List<Partido> partidos;

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

    public void agregarPartido(Partido partido) {
        this.partidos.add(partido);
    }
}
