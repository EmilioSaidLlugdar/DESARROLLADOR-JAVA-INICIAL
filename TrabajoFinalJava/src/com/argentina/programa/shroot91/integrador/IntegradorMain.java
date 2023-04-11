package com.argentina.programa.shroot91.integrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IntegradorMain {


    private Ronda[] rondas;
    private List<Persona> apostadores;

    /*
    * En esta entrega se debe poder soportar que los archivos contengan información de muchas
      rondas y de muchas personas (para eso hay que agregar los datos de ronda y persona en los
      archivos correspondientes).
      Por otro lado, al leer cada línea del archivo de resultados, se debe verificar que la misma sea
      correcta: número correcto de campos y que la cantidad de goles sea un número entero. Cada
      ronda puede tener cualquier cantidad de partidos.
      Al finalizar el programa, se debe imprimir un listado de los puntajes de cada persona que
      participa.
    *
    *
    * */
    public void segundaEntrega(String[] args) {

        Path resultados = Paths.get(args[0]);
        Path pronosticos = Paths.get(args[1]);

        try {

            /// Esto tiene que tomar del archivo de resultados y contar la cantidad de rondas
            // ¿como lo hace? -> identificando la ronda y cuando sea diferente de la anterior sumar la ronda.
            // Entonces recorremos el archivo de resultados creando los partidos y asignando a sus respectivas rondas
            _leerArchivoResultadosYGenerarObjetos(resultados);

            System.out.println("======================================");
            System.out.println();
           _leerArchivoPronosticoYGenerarObjetos(pronosticos);
            calcularPuntaje();



            System.out.println();
            mostrarPuntaje();

        } catch (Exception e) {
            System.out.println("Algun error encontrado" + e.getMessage() + e.getLocalizedMessage());

        }
    }


    private void _leerArchivoResultadosYGenerarObjetos(Path resultados) throws IOException {

        rondas = new Ronda[cantidadRondas(resultados)];

        // Inicializamos el array de rondas con rondas vacias
        for (int i = 0; i < rondas.length; i++) {
            rondas[i] = new Ronda(i + 1); // genera el objeto ronda para calcular su longitud
        }


        for (int i = 1; i <= Files.readAllLines(resultados).size() - 1; i++) {
            String line = Files.readAllLines(resultados).get(i);

            System.out.println(line);
            String[] dataString = line.split(",");

            Partido partidito = new Partido();
            // en la ultima posicion asignamos idPartido
            // agregamos al ultimo por conveniencia para no modificar el codigo y el archivo original
            partidito.setIdPartido(Integer.parseInt(dataString[5]));

            // creacion de equipos
            Equipo equipo1 = new Equipo(dataString[1], "Local");
            Equipo equipo2 = new Equipo(dataString[4], "Visitante");

            // asigancion de equipos al partido
            partidito.setEquipo1(equipo1); //local
            partidito.setEquipo2(equipo2); //visitante

            partidito.setGolesEquipo1(Integer.parseInt(dataString[2]));
            partidito.setGolesEquipo2(Integer.parseInt(dataString[3]));
            System.out.println("Resultado -> " + partidito.resultado());
            System.out.println("===============================");

            // añado el partido a la ronda correspondiente
            rondas[Integer.parseInt(dataString[0]) - 1].agregarPartido(partidito);

        }

    }

    private void _leerArchivoPronosticoYGenerarObjetos(Path pronosticos) throws IOException {
        apostadores = new ArrayList<Persona>();

        /*
         * Recorremos el listado de pronosticos y generamos las personas y asignamos los pronosticos de c/u
         */
        for (int i = 1; i <= Files.readAllLines(pronosticos).size() - 1; i++) {
            String line = Files.readAllLines(pronosticos).get(i);
            String[] dataString = line.split(",");
            String nombre = dataString[0];
            Persona persona; //objeto nulo

            // si no existe la person, la creo y la agrego
            if (getIndexName(apostadores, nombre) == -1) {
                persona = new Persona();
                persona.setNombre(nombre);
                apostadores.add(persona);

            // si existe guardo el indice y muestro su nombre
            } else {
                int indice = getIndexName(apostadores, nombre);
                persona = apostadores.get(indice);
                System.out.println(persona);
            }

            //creamos el pronostico
            Pronostico pronostico = new Pronostico();

            pronostico.setPartido(pronostico.getPartido()); //ver si esta al pedo

            pronostico.setPartido(obtenerPartido(Integer.parseInt(dataString[6]))); // buscamos el partido a travez del id

            if (dataString[2].toLowerCase().contains("x")) {
                pronostico.setResultadoEnum((ResultadoEnum.GANAEQUIPOLOCAL));

            } else if (dataString[4].toLowerCase().contains("x")) {
                pronostico.setResultadoEnum((ResultadoEnum.GANAEQUIPOVISITANTE));
            } else {
                pronostico.setResultadoEnum((ResultadoEnum.EMPATE));
            }
            persona.addPronostico(pronostico);
        }

    }

    /*
    * Muestra el puntaje de cada jugador
    * */
    public void mostrarPuntaje() {
        System.out.println("=============Puntajes=============");
        for (int i = 0; i < apostadores.size(); i++) {
            System.out.println("Jugador " + apostadores.get(i).getNombre() + ", puntaje de rondas -> " +
                    apostadores.get(i).getPuntaje());
        }
    }

    /*
     * Recorre el listado de apostadores, trae sus pronosticos y setea el puntaje de cada apostador
     *
     * */
    public void calcularPuntaje() {
        for (int i = 0; i < apostadores.size(); i++) {
            // Obtenemos la lista de pronosticos para cada persona
            List<Pronostico> pronosticos = apostadores.get(i).
                    getPronosticos();
            // Aqui de cada pronostico se añaden los puntos que se han obtenido
            for (Pronostico p : pronosticos) {
                apostadores.get(i).añadirPuntos(p.consultarPuntos());
            }
        }
    }


    // Se fija cuantas rondas existen segun el archivo de resultados
    // Cuando ve que el id de ronda cambia, suma la cantidad de rondas
    private int cantidadRondas(Path resultados) throws IOException {
        int quantity = 1;
        var aux = "1";
        for (int i = 1; i < Files.readAllLines(resultados).size(); i++) {
            String line = Files.readAllLines(resultados).get(i);
            String[] dataString = line.split(",");
            if (!aux.contains(dataString[0])) {
                quantity++;
                aux = dataString[0];
            }
        }
        return quantity;
    }

    /*
     * Obtiene el indice de un apostador dado el listado de apostadores
     *
     * */
    private int getIndexName(List<Persona> apostadores, String name) {
        int contiene = -1;
        for (int j = 0; j < apostadores.size(); j++) {
            if (apostadores.get(j).getNombre().contains(name)) {
                contiene = j;
            }
        }
        return contiene;
    }

    /*
     * Obtiene el objeto partido segun un id de Partido
     * */
    private Partido obtenerPartido(int idPartido) {
        Partido p = new Partido();
        boolean encontrado = false;

        for (int i = 0; i < rondas.length && !encontrado; i++) {
            Ronda ronda = rondas[i];
            List<Partido> partidos = ronda.getPartidos(); // se econtro el partido
            for (int j = 0; j < partidos.size() && !encontrado; j++) {

                if (partidos.get(j).getIdPartido() == idPartido) { // comparo idPartido de ambos archivos
                    p = partidos.get(j);
                    encontrado = true;
                }

            }
        }
        return p;
    }
}

