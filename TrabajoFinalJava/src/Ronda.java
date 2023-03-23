public class Ronda {
    private int nro;
    private Partido partido;

    public int puntos() {
        return 0;
    }

    public Ronda() {
    }

    public Ronda(int nro, Partido partido) {
        this.nro = nro;
        this.partido = partido;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
