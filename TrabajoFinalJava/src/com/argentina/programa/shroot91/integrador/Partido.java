package com.argentina.programa.shroot91.integrador;

public class Partido {
    private int idPartido;
    private Equipo equipo1;
    private Equipo equipo2;

    private int golesEquipo1;
    private int golesEquipo2;

    public Partido() {

    }

    public Partido(int idPartido, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }


    public ResultadoEnum resultado() {
        //siempre empiezan empatados
        var resultadoEnum = ResultadoEnum.EMPATE;
            // equipo 1 lo defino como ganador o perdedor
            if (this.golesEquipo1 > this.golesEquipo2) {
                resultadoEnum = ResultadoEnum.GANAEQUIPOLOCAL;
            } else if (this.golesEquipo1 < this.golesEquipo2) {
                resultadoEnum = ResultadoEnum.GANAEQUIPOVISITANTE;
            }

        return resultadoEnum;
    }

}
