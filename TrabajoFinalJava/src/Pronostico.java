public class Pronostico {

    private Partido partido;

    private ResultadoEnum resultadoEnum;

    public int puntos() {
        return 0;
    }

    public Pronostico() {
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultadoEnum) {
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
}
