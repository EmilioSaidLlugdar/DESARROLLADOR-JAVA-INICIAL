package org.example.integrador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegradorMainTest {

    @Test
    void segundaEntrega() {
    }

    @Test
    void mostrarPuntaje() {

    }

    @Test
    void calcularPuntaje() {
        Equipo equipo1 = new Equipo("Argentina","local");
        Equipo equipo2 = new Equipo("Arabia","visitante");

        Partido partidoTest = new Partido();

        partidoTest.setEquipo1(equipo1);
        partidoTest.setGolesEquipo1(1);

        partidoTest.setEquipo2(equipo2);
        partidoTest.setGolesEquipo2(0);

        Persona personaTest = new Persona("Lucas");

        Pronostico pronosticoTest = new Pronostico(partidoTest, ResultadoEnum.GANAEQUIPOLOCAL);

        personaTest.addPronostico(pronosticoTest);
        //resolver calcular puntos

        //assertEquals( valor del puntaje, numero del puntaje que esperamos);
    }

    @Test
    void _leerArchivoResultadosYGenerarObjetos() {

    }
}