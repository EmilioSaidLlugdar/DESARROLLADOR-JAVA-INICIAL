package org.example.integrador;

public class Pronostico {
    private Partido partido;
    private ResultadoEnum resultadoEnum;



    public Pronostico() {
    }

    public Pronostico(Partido partido, ResultadoEnum resultadoEnum) {
        this.partido = partido;
        this.resultadoEnum = resultadoEnum;
    }
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

    // preguntar si resultado de partido con resultado de pronostico
    // la persona misma debe poder saber su mismo puntaje y
}
