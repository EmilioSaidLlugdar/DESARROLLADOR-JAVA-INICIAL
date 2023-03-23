import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;

    int golesEquipo1;
    int GolesEquipo2;

    public ResultadoEnum resultado;

    BufferedReader lector;
    String linea;
    String partes[]= null;

    public void leerArchivo(String nombreArchivo){
        try {
            lector= new BufferedReader(new FileReader(nombreArchivo));
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
}
