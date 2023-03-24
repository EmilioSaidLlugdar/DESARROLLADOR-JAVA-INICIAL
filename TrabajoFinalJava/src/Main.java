public class Main {
    public static void main(String[] args){
    Partido partido= new Partido();
    partido.leerArchivo("./recursos/resultados.csv");

    Pronostico pronostico = new Pronostico();
    pronostico.leerArchivo("./recursos/pronostico.csv");
    }
}