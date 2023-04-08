package com.argentina.programa.shroot91.integrador;

public class Pronostico {
    private Partido partido;
    private ResultadoEnum resultadoEnum;


    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public ResultadoEnum getResultadoEnum() {
        return resultadoEnum;
    }

    public void setResultadoEnum(ResultadoEnum resultadoEnum) {
        this.resultadoEnum = resultadoEnum;
    }

    public int consultarPuntos() {
        if (partido.resultado() == this.resultadoEnum) {
            return 1;
        }
        return 0;
    }
}
