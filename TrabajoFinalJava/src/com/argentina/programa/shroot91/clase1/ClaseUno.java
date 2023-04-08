package com.argentina.programa.shroot91.clase1;

import java.util.Scanner;

public class ClaseUno {
    private int a = 5;
    private int b = 14;

    public ClaseUno() {
    }

    public void ejercicioA() {
        int a = this.a;
        int b = this.b;
        System.out.println("LOS NUMERO ENTRE A(" + a + ") Y B(" + b + ") HARDCODEADOS SON");
        while (a <= b) {
            System.out.print(a + " ");
            a++;
        }
    }

    private void _showOddOrEven(String p) {
        int a = this.a;
        int b = this.b;
        Boolean showEven = p.toLowerCase().contains("p");
        if (showEven) {
            System.out.println("\nLOS PARES MOSTRADOS SON ");
        } else {
            System.out.println("\nLOS IMPARES MOSTRADOS SON ");
        }

        while (a <= b) {
            if (_isEven(a) && showEven) {
                System.out.print(a + " ");
            } else if (!showEven && !_isEven(a)) {
                System.out.print(a + " ");
            }
            a++;
        }
    }

    private Boolean _isEven(int i) {
        return (i % 2) == 0;
    }

    public void ejercicioB() {
        _showOddOrEven("P");
    }

    public void ejercicioC() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDESEA IMPRIMIR [P]ares/ [I]mpares :\t");
        String a = sc.nextLine();
        _showOddOrEven(a);
    }

    public void ejercicioD() {
        int a = this.a;
        System.out.println("\nINVERTIR ORDEN DE PARES");
        for (int b = this.b; b >= a; b--) {
            if (b % 2 == 0) {
                System.out.print(b + " ");
            }
        }
    }

    public void ejercicioDos() {
        Boolean isOligarca =false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresos mensuales del hogar");
        float ingresosHogar = sc.nextFloat();
        if((ingresosHogar >= 489083.00)){
            isOligarca=true;
        }

        if(true){

        }
        System.out.println("Ingrese la cantidad de vehiculos que posee con antiguedad a 5 años");
        int cantVehiculos = sc.nextInt();
        System.out.println("Ingrese la cantidad de inmuebles que posee");
        int inmuebles = sc.nextInt();
        System.out.println("¿Posee una embarcación, aeronave de lujo o activos societarios? Presione [0]No / [1]Si ");
        int privilegiado = sc.nextInt();

        if ((ingresosHogar >= 489083.00) ||
                (cantVehiculos >= 3) || (inmuebles >= 3) ||
                (privilegiado == 1)) {
            System.out.println("Usted de seguro que pertenece a la oligarquia de derecha '\s' ");
        } else {
            System.out.println("Usted es pobre...  Viva Perón *Suena la marcha peronista*");
        }

    }
}
