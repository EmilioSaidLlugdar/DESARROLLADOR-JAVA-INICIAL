import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

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
//*********************************************************************************
    String linea;
    String partes[]= null;
    public void leerArchivo(String nombreArchivo){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine())!= null){
                partes = linea.split(",");
                imprimirLinea();
                System.out.println();
            }
            lector.close();
            linea= null;
            partes=null;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }

        public void imprimirLinea(){
            for (int i=0; i< partes.length; i++){
                System.out.println(partes[i]+ " | ");
            }
        }














    //------------------------------------------------------------
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
